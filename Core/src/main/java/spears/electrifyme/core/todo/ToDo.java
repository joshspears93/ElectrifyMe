package spears.electrifyme.core.todo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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