package todomanager;

import org.hibernate.Session;

import java.util.GregorianCalendar;

/**
 * Created by Konstantin on 06.11.2016.
 */
public class TodoManager {
    public static void main(String[] args) {
        addTask();
    }

    /**
     * Метод создает таблицу в базе данных при развертовании базы
     */
    public static void createTable(){

    }
    private static void addTask(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Task task = new Task("Task 7",new GregorianCalendar(),new GregorianCalendar(), true);
        session.save(task);
        session.getTransaction().commit();
    }
}

