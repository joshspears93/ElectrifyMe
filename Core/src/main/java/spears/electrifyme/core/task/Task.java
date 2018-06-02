package spears.electrifyme.core.task;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "task")
public class Task {

    @Id
    String id = UUID.randomUUID().toString();
    @Indexed
    String task;
    Stage stage;
    Scope scope;
    Instant dateCreated;
    Instant dateToComplete;
    Boolean reminder;
    List<Task> subtasks;
    


    public Task(){

    }

    public Task(String task, Stage stage, Scope scope, Instant dateCreated,Instant dateToComplete, boolean reminder, Task subtask){
        this.task = task;
        this.stage = stage;
        this.scope = scope;
        this.dateCreated = dateCreated;
        this.dateToComplete = dateToComplete;
        this.reminder = reminder;
        this.subtasks.add(subtask);
    }



}