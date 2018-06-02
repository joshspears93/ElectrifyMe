package spears.electrifyme.core.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("taskController")
@RequestMapping("${spring.data.rest.base-path}/tasks")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TaskServiceImpl taskService;

    /**
     * Get all tasks
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Task>> listAllTasks(){
        List<Task> tasks = taskService.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    /**
     * Get one task
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable("id") String id){
        Optional<Task> todo = taskService.findTaskById(id);
        return ResponseEntity.ok().body(todo);
    }

    /**
     * Create a task
     */
    @PostMapping("/add")
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
        Task newToDo = taskService.createTask(task);
        return ResponseEntity.ok().body(newToDo);
    }

    /**
     * Update a task
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateTask(@Valid @RequestBody Task task){
        Task response = taskService.updateTask(task);
        if(response != null){
            return ResponseEntity.ok().body(response);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a task
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") String id){
        if(taskRepository.findById(id).isPresent() ){
            taskService.deleteTaskById(id);
            //taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete all tasks
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllTasks(){
        taskService.deleteAllTasks();
        //taskRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
