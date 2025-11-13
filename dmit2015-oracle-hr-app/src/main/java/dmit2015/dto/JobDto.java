package dmit2015.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobDto {

    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;

}
