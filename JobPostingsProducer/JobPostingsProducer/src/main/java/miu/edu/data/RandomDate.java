package miu.edu.data;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomDate {
    public static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        Random random = new Random();
        int daysToAdd = random.nextInt(30) + 1; // upto next 30 days
        calendar.add(Calendar.DATE, daysToAdd);
        Date randomDate = calendar.getTime();
        return randomDate;
    }
}
