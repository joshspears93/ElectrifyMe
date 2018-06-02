package spears.electrifyme.core.task;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface TaskRepository extends MongoRepository<Task, String>, TaskRepositoryCustom {
}
