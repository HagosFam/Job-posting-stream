package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CompanySize {
    private static final List<String> COMPANY_SIZES = List.of("1000+ employees","500-999 employees","100-499 employees","50-99 employees","10-49 employees","< 10 employees");
    public static String size() {
        return COMPANY_SIZES.get(new Random().nextInt(COMPANY_SIZES.size()));
    }
}
