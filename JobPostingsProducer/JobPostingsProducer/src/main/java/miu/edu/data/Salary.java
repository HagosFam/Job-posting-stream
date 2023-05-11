package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Salary {
    private static final List<String> SALARIES = Arrays.asList(
            "$80,000 - $100,000 a year",
            "$100,000 - $120,000 a year",
            "$120,000 - $150,000 a year",
            "$150,000 - $180,000 a year",
            "$180,000 - $200,000 a year"
    );
    public static String range() {
        return SALARIES.get(new Random().nextInt(SALARIES.size()));
    }
}
