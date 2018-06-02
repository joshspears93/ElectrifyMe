package spears.electrifyme.core.task;

import java.util.List;

public interface TaskRepositoryCustom {

    //Custom method definition goes here
    List<Task> getTaskByDateAndNotCompleted();
}
