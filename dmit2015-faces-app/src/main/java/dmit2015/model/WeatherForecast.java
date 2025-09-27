package dmit2015.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Data
@NoArgsConstructor
public class WeatherForecast {

    private String id;
    private String city;
    private LocalDate date;
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
