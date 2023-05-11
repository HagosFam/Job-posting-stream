package miu.edu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper<T> {
    public static String mapToString(JobPosting jobPosting) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(jobPosting);
    }

    public static <T> T mapToObject(String message, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(message, clazz);
    }
}
