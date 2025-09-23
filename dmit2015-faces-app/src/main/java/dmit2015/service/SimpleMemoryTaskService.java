package dmit2015.service;

import dmit2015.model.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Named("simpleMemoryTaskService")
@ApplicationScoped
public class SimpleMemoryTaskService implements TaskService {

    private List<Task> tasks = new ArrayList<>();

    @Override
    public Task createTask(Task task) {
        task.setId(UUID.randomUUID().toString());
        tasks.add(task);
        return task;
    }

    @Override
    public Optional<Task> getTaskById(String id) {
        return tasks
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public Task updateTask(Task task) {
        return task;
    }

    @Override
    public void deleteTaskById(String id) {
        tasks.remove(getTaskById(id).orElseThrow());
    }
}
