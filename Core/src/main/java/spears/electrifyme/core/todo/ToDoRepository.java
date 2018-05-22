package spears.electrifyme.core.todo;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ToDoRepository extends MongoRepository<ToDo, String>, ToDoRepositoryCustom {
}
