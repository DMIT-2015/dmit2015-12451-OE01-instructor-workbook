package dmit2015.model;

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
public class Task {

    private String id;

    private String description;

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
