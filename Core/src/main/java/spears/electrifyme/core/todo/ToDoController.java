package spears.electrifyme.core.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("todoController")
@RequestMapping("${spring.data.rest.base-path}/todos")
@CrossOrigin("*")
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ToDoServiceImpl toDoService;

    /**
     * Get all to do tasks
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<ToDo>> listAllToDos(){
        List<ToDo> tasks = toDoService.findAllTodos();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    /**
     * Get one to do tasks
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getToDoById(@PathVariable("id") String id){
        Optional<ToDo> todo = toDoService.findToDoById(id);
        return ResponseEntity.ok().body(todo);
    }

    /**
     * Create a to do task
     */
    @PostMapping("/add")
    public ResponseEntity<ToDo> createToDo(@Valid @RequestBody ToDo todo){
        ToDo newToDo = toDoService.createToDo(todo);
        return ResponseEntity.ok().body(newToDo);
    }

    /**
     * Update one to do task
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateToDo(@Valid @RequestBody ToDo todo){
        ToDo response = toDoService.updateToDo(todo);
        if(response != null){
            return ResponseEntity.ok().body(response);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete one to do task
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") String id){
        if(toDoRepository.findById(id).isPresent() ){
            toDoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete all to do tasks
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllToDos(){
        toDoRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
