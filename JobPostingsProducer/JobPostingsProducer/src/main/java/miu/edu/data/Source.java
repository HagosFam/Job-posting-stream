package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Source {
    private static final List<String> SOURCES = Arrays.asList("Indeed", "LinkedIn", "Glassdoor", "Monster", "ZipRecruiter");

    public static String required() {
        return SOURCES.get(new Random().nextInt(SOURCES.size()));
    }
}
