package miu.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void send(String message) {
        String queue = "job-posting";
        jmsTemplate.convertAndSend(queue, message);
    }
}
