package spears.electrifyme.core.todo;


import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, String> {
}
