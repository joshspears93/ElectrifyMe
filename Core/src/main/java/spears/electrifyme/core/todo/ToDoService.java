package spears.electrifyme.core.todo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    List<ToDo> findAllTodos();

    Optional<ToDo> findToDoById(String id);

    ToDo createToDo(ToDo todo);

    ToDo updateToDo(String id, ToDo todo);

    void deleteToDoById(String id);

    void deleteAllToDos();
}
