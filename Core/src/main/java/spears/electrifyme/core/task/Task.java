package spears.electrifyme.core.task;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.UUID;

@Data
@Document(collection = "task")
public class Task {

    //TODO Add stages to make task like a kanbann board

    @Id
    String id = UUID.randomUUID().toString();
    @Indexed
    String task;
    Boolean completed;
    Instant dateToComplete;
    Boolean reminder;

    public Task(){

    }

    public Task(String task, boolean completed, Instant dateToComplete, boolean reminder){
        this.task = task;
        this.completed = completed;
        this.dateToComplete = dateToComplete;
        this.reminder = reminder;
    }



}