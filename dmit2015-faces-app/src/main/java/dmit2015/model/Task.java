package dmit2015.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.datafaker.Faker;

import java.util.UUID;
import java.util.random.RandomGenerator;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @Column(name="taskid", nullable = false, unique = true)
    private String id;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @Pattern(regexp = "^(Low|Medium|High)$", message = "Priority must be Low, Medium, or High")
    private String priority; // Low, Medium, High

    private boolean done;

    // copy constructor
    public Task(Task other) {
        this.id = other.getId();
        this.description = other.getDescription();
        this.priority = other.getPriority();
        this.done = other.isDone();
    }

    public static Task copyOf(Task other) {
        return new Task(other);
    }

    public static Task of(Faker faker) {
        var task = new Task();
        task.setId(UUID.randomUUID().toString());
        task.setDescription(faker.fallout().quote());
        String[] priorities = {"Low","Medium","High"};
        RandomGenerator rand = RandomGenerator.getDefault();
        String randomPriority = priorities[rand.nextInt(priorities.length)];
        task.setPriority(randomPriority);
        task.setDone(faker.bool().bool());
        return task;
    }
}
