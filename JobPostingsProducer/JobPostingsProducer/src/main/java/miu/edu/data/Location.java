package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Location {
    private static final List<String> LOCATIONS = Arrays.asList(
            "New York, NY",
            "San Francisco, CA",
            "Seattle, WA",
            "Chicago, IL",
            "Boston, MA",
            "Los Angeles, CA",
            "Washington, D.C.",
            "Austin, TX",
            "Denver, CO",
            "Atlanta, GA"
    );
    public static String name() {
        return LOCATIONS.get(new Random().nextInt(LOCATIONS.size()));
    }
}
