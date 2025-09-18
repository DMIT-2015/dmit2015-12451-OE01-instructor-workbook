package dmit2015.faces;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import net.datafaker.Faker;
import org.omnifaces.util.Messages;

/**
 * Request-scoped backing bean: new instance per HTTP request.
 * Use for simple actions/data that don't need to persist after the response.
 */
@Named("greetingBeanRequest")
@RequestScoped // New instance per HTTP request; no Serializable required
public class GreetingBeanRequest {

    @NotBlank(message = "Username cannot be blank.")
    @Getter
    @Setter
   private String username;

    public void onSubmit() {
//        Messages.addGlobalInfo("Hello {0} to Faces world!", username);
        var faker = new Faker(Locale.SIMPLIFIED_CHINESE);
        String message = String.format(
                "Hello, %s! Your Chinese name is %s and your Baseball team is %s",
                username,
                faker.name().fullName(),
                faker.baseball().teams());
        Messages.addGlobalInfo(message);
    }

    public void onGenerateName() {
        var faker = new Faker(new Locale.Builder().setLanguage("ar").build());
        username = faker.name().fullName();
    }

}
