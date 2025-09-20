package dmit2015.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Task {

    private String description;

    private String priority; // Low, Medium, High

    private boolean done;

}
