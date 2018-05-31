package spears.electrifyme.core.todo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Data
@Document(collection = "todo")
public class ToDo {

    @Id
    String id;
    @Indexed
    String task;
    Boolean completed;
    Instant dateToComplete;
    Boolean reminder;

    public ToDo(){

    }

    public ToDo(String task, boolean completed, Instant dateToComplete, boolean reminder){
        this.task = task;
        this.completed = completed;
        this.dateToComplete = dateToComplete;
        this.reminder = reminder;
    }



}