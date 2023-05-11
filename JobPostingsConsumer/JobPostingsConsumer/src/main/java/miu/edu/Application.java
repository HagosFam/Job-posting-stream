package miu.edu;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableJms
@EnableKafka
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String[] args) throws JsonProcessingException {
	}

}
