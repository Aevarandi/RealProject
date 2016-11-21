package todomanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todomanager.dao.TaskDAO;
import todomanager.domain.Task;

import java.util.List;

/**
 * Created by Konstantin on 17.11.2016.
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskDAO taskDAO;

    @Transactional
    public void addTask(Task task) {
        taskDAO.addTask(task);
    }

    @Transactional
    public List<Task> listTask() {
        return taskDAO.listTask();
    }

    @Transactional
    public void deleteTask(int id) {
        taskDAO.removeTask(id);
    }
}
