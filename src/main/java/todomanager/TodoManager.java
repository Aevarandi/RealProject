package todomanager;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Konstantin on 06.11.2016.
 */
public class TodoManager {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.FATAL);
        List<Task> tasks =listTasks();
        if (tasks.size() == 0){
            fillDatabaseWithTesData();
        }


    }


    private static void addTask(Task task){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(task);
        session.getTransaction().commit();
    }
    private static List<Task> listTasks(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Task> result = session.createQuery("from todomanager.Task").list();
        session.getTransaction().commit();
        return  result;
    }
    private static void deleteTasks(List<Task> result){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        for (Task task: result
             ) {
            session.delete(task);
        }
        session.getTransaction().commit();

    }
    private static void deleteEntity(Object o){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(o);
        session.flush();
        session.getTransaction().commit();
    }
    private static void fillDatabaseWithTesData(){
        addTask(new Task("Сделать тестовое задания к реальному проекту", new GregorianCalendar(2016,11, 25), new GregorianCalendar(), false ));
        addTask(new Task("Помыть посуду", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), false ));
        addTask(new Task("Выпить пива", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), true ));
        addTask(new Task("Помыть машину", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), false ));
        addTask(new Task("Съездить в отпуск", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), true ));
        addTask(new Task("Выучить английский", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), false ));
        addTask(new Task("Найти новую работу", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), true ));
        addTask(new Task("Купить цветы", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), false ));
        addTask(new Task("Выспаться", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), true ));
        addTask(new Task("Почистить зубы", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), false ));
        addTask(new Task("Какое-то задание на которое мне лениво придумывать текст", new GregorianCalendar(2016,10, 11), new GregorianCalendar(), true ));

    }
}

