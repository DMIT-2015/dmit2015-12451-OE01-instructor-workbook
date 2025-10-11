package dmit2015.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.random.RandomGenerator;

/**
 * This Jakarta Persistence class is mapped to a relational database table with the same name.
 * If Java class name does not match database table name, you can use @Table annotation to specify the table name.
 * <p>
 * Each field in this class is mapped to a column with the same name in the mapped database table.
 * If the field name does not match database table column name, you can use the @Column annotation to specify the database table column name.
 * The @Transient annotation can be used on field that is not mapped to a database table column.
 */
@Entity
//@Table(schema = "CustomSchemaName", name="CustomTableName")
@Getter
@Setter
public class WeatherForecast implements Serializable {

    private static final Logger logger = Logger.getLogger(WeatherForecast.class.getName());

    @Id
    @Column(name = "weatherid", nullable = false)
    private String id;

    @NotBlank(message = "City value cannot be blank.")
    private String city;
    @Future(message = "Date must be in the future.")
    private LocalDate date;
    @Min(value = -40, message = "TempC must between -40 and 40")
    @Max(value = 40, message = "TempC must between -40 and 40")
    private int temperatureCelsius;

    public int getTemperatureFahrenheit() {
        return (int) (32 + temperatureCelsius / 0.5556);
    }

    public WeatherForecast() {

    }

    @Version
    private Integer version;

    @Column(nullable = false)
    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @PrePersist
    private void beforePersist() {
        createTime = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate() {
        updateTime = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object obj) {
        return (
                (obj instanceof WeatherForecast other) &&
                        Objects.equals(id, other.id)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static WeatherForecast of(Faker faker) {
        var randomGenerator = RandomGenerator.getDefault();
        var currentWeather = new WeatherForecast();
        currentWeather.setId(UUID.randomUUID().toString());
        currentWeather.setCity(faker.address().city());
        currentWeather.setDate(LocalDate.now());
        currentWeather.setTemperatureCelsius(faker.number().numberBetween(-30, 35));
        return currentWeather;
    }

}