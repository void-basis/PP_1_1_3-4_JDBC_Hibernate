package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static final SessionFactory factory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (Id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), lastName VARCHAR(20), age INT)").executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS users").executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = factory.openSession();
        session.beginTransaction();
        User user = new User("1", "2", (byte) 3);
        session.save(user);
        user.setAge(age);
        user.setName(name);
        user.setLastName(lastName);
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            session.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("такого юзера нет в базе");
        }
    }

    @Override
    public List<User> getAllUsers() {
            List<User> lst;
            Session session = factory.openSession();
            session.beginTransaction();
            lst = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
            return lst;
    }

    @Override
    public void cleanUsersTable() {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createSQLQuery("delete from Users").executeUpdate();
        session.getTransaction().commit();
    }
}
