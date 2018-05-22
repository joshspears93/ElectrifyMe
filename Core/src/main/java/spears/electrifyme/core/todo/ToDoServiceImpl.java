package spears.electrifyme.core.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("todoService")
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public List<ToDo> findAllTodos(){
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return toDoRepository.findAll(sortByCreatedAtDesc);
    }

    @Override
    public Optional<ToDo> findToDoById(String id){
        return toDoRepository.findById(id);
    }

    @Override
    public ToDo createToDo(ToDo todo){
        return toDoRepository.save(todo);
    }

    @Override
    public ToDo updateToDo(String id, ToDo todo){
        if(toDoRepository.findById(id).isPresent()){
            return toDoRepository.save(todo);
        }
        else{
            return new ToDo();
        }

    }

    @Override
    public void deleteToDoById(String id){
        toDoRepository.deleteById(id);

    }

    @Override
    public void deleteAllToDos(){
        toDoRepository.deleteAll();
    }
}
