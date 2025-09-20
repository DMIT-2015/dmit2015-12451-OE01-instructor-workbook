package dmit2015.faces;

import dmit2015.model.Task;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Session-scoped backing bean: per-user state that persists for the HTTP session.
 * Implements Serializable for passivation.
 */
@Named("taskManagerSession")
@SessionScoped // Lives for the user's session; store only per-user state
public class TaskManagerSession implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(TaskManagerSession.class.getName());

    @Getter
    private List<Task> tasks = new ArrayList<Task>();

    @Getter @Setter
    private Task newTask = new Task();

    // ActionListener method to handle request to add new Task
    public void addTask() {
        // add the newTask to the system
        tasks.add(newTask);
        // send feedback message to FacesContext
        Messages.addGlobalInfo("New task added: {0}", newTask);
        // clear form
        newTask = new Task();
    }

    // ActionListener method to handle request to remove a Task
    public void removeTask(Task currentTask) {
        tasks.remove(currentTask);
        Messages.addGlobalInfo("Task removed: {0}", currentTask);
    }

}
