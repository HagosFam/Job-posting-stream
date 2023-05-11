package miu.edu;

import lombok.*;
import java.util.Date;

@Builder
@Data
@ToString
public class JobPosting {
    private String company;
    private String companyRating;
    private String companySize;
    private String education;
    private String experience;
    private String industry;
    private String jobTitle;
    private String jobLevel;
    private String jobType;
    private String location;
    private String salaryRange;
    private String skill;
    private String source;
    private String summary;
    private Date openFrom;
    private int count;
}
