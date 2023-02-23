package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    static String url = "jdbc:mysql://localhost/mydb1";
    static String login = "root";
    static String password = "кщще";
    private static Connection connection;

    public static Connection getConnection() {     // модификаторы ???
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }
        return connection;
    }

    private static SessionFactory sessionFactory;
    public static final SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");    // уточнить
                settings.put(Environment.URL, "jdbc:mysql://localhost/mydb1");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "кщще");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");    // зечем это забыл

                //settings.put(Environment.HBM2DDL_AUTO, "");   // ???? зечем это

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void closeSessionFactory() {      // надо нет ? проверить
        sessionFactory.close();
    }
}
