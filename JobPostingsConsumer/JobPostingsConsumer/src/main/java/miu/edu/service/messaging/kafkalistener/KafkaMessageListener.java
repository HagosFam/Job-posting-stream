package miu.edu.service.messaging.kafkalistener;

import com.fasterxml.jackson.core.JsonProcessingException;
import miu.edu.domain.JobPosting;
import miu.edu.service.JobPostingServiceImpl;
import miu.edu.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.stream.IntStream;

@Component
public class KafkaMessageListener {
    @Autowired
    private JobPostingServiceImpl jobPostingService;

    @KafkaListener(topics = {"job-posting"})
    public void receive(String message) throws JsonProcessingException {
        JobPosting jobPosting = Mapper.mapToObject(message, JobPosting.class);
        jobPostingService.save(jobPosting).subscribe();
    }
}