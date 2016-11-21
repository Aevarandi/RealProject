package todomanager.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Konstantin on 06.11.2016.
 */

@Entity
@Table(name = "TASKS")
public class Task{

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id ;

    @Column(name = "task_name")
    private String name;

    @Column(name = "completion_date")
    private Calendar completionDate;

    @Column(name = "creation_date")
    private Calendar creationDate;

    @Column(name = "is_done")
    private  boolean done;

    public Task(String name, Calendar completionDate, Calendar creationDate, boolean isDone) {
        this.name = name;
        this.completionDate = completionDate;
        this.creationDate = creationDate;
        this.done = isDone;
    }

    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Calendar completionDate) {
        this.completionDate = completionDate;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
