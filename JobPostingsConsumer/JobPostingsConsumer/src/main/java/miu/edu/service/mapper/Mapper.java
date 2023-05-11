package miu.edu.service.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import miu.edu.domain.JobPosting;

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
