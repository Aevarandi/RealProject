package todomanager.service;

import todomanager.domain.Task;

import java.util.List;

/**
 * Created by Konstantin on 17.11.2016.
 */

public interface TaskService
{
    public void addTask(Task task);

    public List<Task> listTask();

    public void deleteTask(int id);
}
