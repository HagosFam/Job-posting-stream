package miu.edu;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import miu.edu.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PublisherSchedule {
    @Autowired
    KafkaPublisher publisher;

    @Autowired
    JmsSender jmsSender;

    @Scheduled(fixedRate = 5000) //run every 15 seconds
    public void run() throws JsonProcessingException {
        //jmsSender.send(Mapper.mapToString(generate()));
        publisher.publish(Mapper.mapToString(generate()));
    }

    public JobPosting generate() {
        return JobPosting.builder()
                .company(Company.name())
                .companyRating(CompanyRating.rating())
                .companySize(CompanySize.size())
                .education(Education.level())
                .experience(Experience.required())
                .industry(Industry.name())
                .jobTitle(Job.title())
                .jobLevel(Job.level())
                .jobType(Job.type())
                .location(Location.name())
                .salaryRange(Salary.range())
                .skill(Skill.required())
                .source(Source.required())
                .summary(Summary.text())
                .openFrom(RandomDate.getDate())
                .count(new Random().nextInt(1000))
                .build();
    }
}
