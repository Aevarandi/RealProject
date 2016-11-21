package todomanager.dao;

import org.springframework.transaction.annotation.Transactional;
import todomanager.domain.Task;

import java.util.List;

/**
 * Created by Konstantin on 17.11.2016.
 */
public interface TaskDAO {

    public void addTask(Task task);


    public List<Task> listTask();

    public void removeTask(int i);
}
