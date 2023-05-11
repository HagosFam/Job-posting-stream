package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Education {
    private static final List<String> REQUIRED_EDUCATIONS = Arrays.asList(
            "Bachelor's degree",
            "Master's degree",
            "PhD"
    );
    public static String level() {
        return REQUIRED_EDUCATIONS.get(new Random().nextInt(REQUIRED_EDUCATIONS.size()));
    }
}
