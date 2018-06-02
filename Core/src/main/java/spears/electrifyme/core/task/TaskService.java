package spears.electrifyme.core.task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<Task> findAllTasks();

    Optional<Task> findTaskById(String id);

    Task createTask(Task task);

    Task updateTask(Task task);

    void deleteTaskById(String id);

    void deleteAllTasks();
}
