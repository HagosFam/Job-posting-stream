package miu.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String message) {
        String topic = "job-posting";
        kafkaTemplate.send(topic, message);
    }
}
