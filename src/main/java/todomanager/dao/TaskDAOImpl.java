package todomanager.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import todomanager.domain.Task;

import java.util.List;

/**
 * Created by Konstantin on 17.11.2016.
 */
@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addTask(Task task) {
        sessionFactory.getCurrentSession().save(task);

    }

    @SuppressWarnings("unchecked")
    public List<Task> listTask() {
        return sessionFactory.getCurrentSession().createQuery("from Task ").list();
    }

    public void removeTask(int id) {
        Task task = (Task) sessionFactory.getCurrentSession().load(Task.class, id);
        if (task != null){
            sessionFactory.getCurrentSession().delete(task);
        }

    }
}
