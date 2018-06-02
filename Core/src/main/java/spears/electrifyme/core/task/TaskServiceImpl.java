package spears.electrifyme.core.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository toDoRepository;

    @Override
    public List<Task> findAllTasks(){
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return toDoRepository.findAll(sortByCreatedAtDesc);
    }

    @Override
    public Optional<Task> findTaskById(String id){

        return toDoRepository.findById(id);
    }

    @Override
    public Task createTask(Task todo){
        return toDoRepository.save(todo);
    }

    @Override
    public Task updateTask(Task todo){
        if(toDoRepository.findById(todo.id).isPresent()){
            return toDoRepository.save(todo);
        }
        else{
            return null;
        }

    }

    @Override
    public void deleteTaskById(String id){
        toDoRepository.deleteById(id);

    }

    @Override
    public void deleteAllTasks(){

        toDoRepository.deleteAll();
    }
}
