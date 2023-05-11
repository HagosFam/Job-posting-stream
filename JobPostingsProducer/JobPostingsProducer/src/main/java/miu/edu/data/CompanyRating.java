package miu.edu.data;

import java.util.List;
import java.util.Random;

public class CompanyRating {
    private static final List<String> COMPANY_RATINGS = List.of(
            "4.5 stars",
            "4 stars",
            "3.5 stars",
            "3 stars",
            "2.5 stars"
    );

    public static String rating() {
        return COMPANY_RATINGS.get(new Random().nextInt(COMPANY_RATINGS.size()));
    }
}
