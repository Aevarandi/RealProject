package todomanager;

import java.util.Calendar;


/**
 * Created by Konstantin on 06.11.2016.
 */
public class Task{
    private int id ;
    private String name;
    private transient   Calendar completionDate;
    private transient  Calendar creationDate;
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
