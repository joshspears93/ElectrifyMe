package spears.electrifyme.core.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("todoController")
@RequestMapping("${spring.data.rest.base-path}/todo")
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    /**
     * Get all to do tasks
     */

    /**
     * Get one to do tasks
     */

    /**
     * Create a to do task
     */

    /**
     * Update one to do task
     */

    /**
     * Delete one to do task
     */

    /**
     * Delete all to do tasks
     */
}
