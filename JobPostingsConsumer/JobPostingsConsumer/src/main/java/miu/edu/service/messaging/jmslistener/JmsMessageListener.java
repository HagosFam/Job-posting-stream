package miu.edu.service.messaging.jmslistener;

import com.fasterxml.jackson.core.JsonProcessingException;
import miu.edu.domain.JobPosting;
import miu.edu.service.JobPostingServiceImpl;
import miu.edu.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageListener {
    @Autowired
    private JobPostingServiceImpl jobPostingService;
    @JmsListener(destination = "job-posting")
    public void receive(String message) throws JsonProcessingException {
        JobPosting jobPosting = Mapper.mapToObject(message, JobPosting.class);
        jobPostingService.save(jobPosting).subscribe();
    }
}
