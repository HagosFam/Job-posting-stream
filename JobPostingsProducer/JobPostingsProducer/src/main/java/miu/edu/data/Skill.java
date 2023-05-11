package miu.edu.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Skill {
    private static final List<String> SKILLS = Arrays.asList(
            "Python", "Machine Learning", "Data Analysis", "Statistics", "SQL",
            "Java", "Big Data", "Data Visualization", "Tableau", "Power BI",
            "R", "Deep Learning", "NLP", "Computer Vision", "TensorFlow",
            "JavaScript", "React", "Angular", "Node.js", "Express.js",
            "Project Management", "Agile", "Scrum", "Lean", "Kanban"
    );
    public static String required() {
        return SKILLS.get(new Random().nextInt(SKILLS.size()));
    }
}
