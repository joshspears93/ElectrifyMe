package spears.electrifyme.core.todo;

import java.util.List;

public interface ToDoRepositoryCustom {

    //Custom method definition goes here
    List<ToDo> getTaskByDateAndNotCompleted();
}
