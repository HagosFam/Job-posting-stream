package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Industry {
    private static final List<String> INDUSTRIES = Arrays.asList(
            "Technology",
            "Finance",
            "Healthcare",
            "Retail",
            "Manufacturing"
    );
    public static String name() {
        return INDUSTRIES.get(new Random().nextInt(INDUSTRIES.size()));
    }
}
