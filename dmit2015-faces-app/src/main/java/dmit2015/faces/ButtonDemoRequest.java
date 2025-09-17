package dmit2015.faces;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.omnifaces.util.Messages;

/**
 * Request-scoped backing bean: new instance per HTTP request.
 * Use for simple actions/data that don't need to persist after the response.
 */
@Named("buttonDemoRequest")
@RequestScoped // New instance per HTTP request; no Serializable required
public class ButtonDemoRequest {

    // Define an actionListener method handler
    public void handleClick() {
        // Send a FacesMessage to FacesContext
        Messages.addGlobalInfo("Button clicked using actionListener!");
    }

    // Define an action method handler that could navigate to another url
    public String submit() {
        Messages.addGlobalInfo("Button clicked using action!");
        return null;    // null or "" to stay in the page
    }

    public String handleLogin() {
        // perform some task
        return "/index.xhtml?faces-redirect=true";
    }
}
