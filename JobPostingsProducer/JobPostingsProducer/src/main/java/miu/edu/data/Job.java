package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Job {
    private static final List<String> TITLES = Arrays.asList(
            "Senior Data Scientist",
            "Data Analyst",
            "Machine Learning Engineer",
            "Software Engineer",
            "Product Manager",
            "Data Engineer",
            "Data Scientist",
            "Data Architect",
            "Business Analyst",
            "Database Administrator",
            "Project Manager",
            "UI/UX Designer",
            "Marketing Manager",
            "Sales Manager",
            "Operations Manager",
            "Human Resources Manager",
            "Financial Analyst",
            "Accountant",
            "Customer Support Representative",
            "Technical Writer"
    );
    public static String title() {
        return TITLES.get(new Random().nextInt(TITLES.size()));
    }
    private static final List<String> LEVELS = Arrays.asList(
            "Entry-level",
            "Mid-level",
            "Senior",
            "Executive"
    );
    public static String level() {
        return LEVELS.get(new Random().nextInt(LEVELS.size()));
    }

    private static final List<String> TYPES = Arrays.asList(
            "Full-time",
            "Part-time",
            "Contract",
            "Temporary",
            "Internship"
    );

    public static String type() {
        return TYPES.get(new Random().nextInt(TYPES.size()));
    }
}
