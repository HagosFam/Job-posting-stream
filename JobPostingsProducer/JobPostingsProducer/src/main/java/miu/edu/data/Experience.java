package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Experience {
    private static final List<String> REQUIRED_EXPERIENCES = Arrays.asList(
            "1-2 years",
            "3-5 years",
            "5-7 years",
            "7+ years"
    );
    public static String required() {
        return REQUIRED_EXPERIENCES.get(new Random().nextInt(REQUIRED_EXPERIENCES.size()));
    }
}
