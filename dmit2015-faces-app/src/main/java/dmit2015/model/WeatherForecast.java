package dmit2015.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Data
@NoArgsConstructor
@Entity
public class WeatherForecast {

    @Id
    @Column(name = "weatherid", nullable = false, unique = true)
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

    // copy constructor
    public WeatherForecast(WeatherForecast other) {
        this.id = other.getId();
        this.city = other.getCity();
        this.date = other.getDate();
        this.temperatureCelsius = other.getTemperatureCelsius();
    }

    public static WeatherForecast copyOf(WeatherForecast other) {
        return new WeatherForecast(other);
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
