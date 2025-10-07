package dmit2015.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @Column(name = "studentid", nullable = false, unique = true)
    private String id;

    @NotBlank(message = "Student Name cannot be blank.")
    private String fullName;

    @NotBlank(message = "Course Term Section cannot be blank.")
    private String courseTermSection;

    private String picture;

    // copy constructor
    public Student(Student other) {
        this.id = other.id;
        this.fullName = other.fullName;
        this.courseTermSection = other.courseTermSection;
        this.picture = other.picture;
    }

    public static Student copyOf(Student other) {
        return new Student(other);
    }

    public static Student of(Faker faker) {
        var newStudent = new Student();
        newStudent.setId(UUID.randomUUID().toString());
        newStudent.setFullName(faker.name().fullName());
        newStudent.setCourseTermSection("DMIT2015-1251-OE01");
        return newStudent;
    }

}
