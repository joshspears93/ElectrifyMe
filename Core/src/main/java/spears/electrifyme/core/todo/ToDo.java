package spears.electrifyme.core.todo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.Date;

@Data
@Document(collection = "todo")
public class ToDo {

    @Id
    String id;
    String task;
    boolean completed;
    Date dateToComplete;
    boolean reminder;
    Time timeToComplete;

    public ToDo(){

    }

    public ToDo(String task, boolean completed, Date dateToComplete, boolean reminder, Time timeToComplete){
        this.task = task;
        this.completed = completed;
        this.dateToComplete = dateToComplete;
        this.reminder = reminder;
        this.timeToComplete = timeToComplete;
    }



}