package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Summary {
    private static final List<String> SUMMARIES = Arrays.asList(
            "We are seeking a talented Data Scientist to join our team...",
            "As a Senior Data Scientist at Acme Corporation, you will be responsible for...",
            "We are looking for a highly motivated Machine Learning Engineer to...",
            "We are seeking a Data Analyst to support our growing business...",
            "We are looking for a passionate Software Engineer to join our team...",
            "We are seeking a Full Stack Developer with experience in...",
            "We are looking for an experienced Product Manager to lead...",
            "As a UX Designer, you will be responsible for designing user-friendly...",
            "We are seeking a talented UI Designer to create beautiful and...",
            "We are looking for a dynamic Marketing Manager to drive...",
            "We are seeking a Sales Representative to join our growing team...",
            "We are looking for a Business Analyst to support our strategic...",
            "As a Project Manager, you will be responsible for managing...",
            "We are seeking a Financial Analyst to join our team and...",
            "As an Operations Manager, you will be responsible for overseeing...",
            "We are looking for an experienced Human Resources Manager to...",
            "We are seeking a Customer Service Representative to provide...",
            "We are looking for a Technical Writer to create clear and...",
            "We are seeking a talented Content Creator to produce engaging..."
    );

    public static String text() {
        return SUMMARIES.get(new Random().nextInt(SUMMARIES.size()));
    }
}
