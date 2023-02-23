package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
            UserDao userDao = new UserDaoHibernateImpl();  //++
            //UserDao userDao = new UserDaoJDBCImpl();   //++

            userDao.createUsersTable(); //++

            userDao.saveUser("Name1", "LastName1", (byte) 20);  //++
            System.out.println("User с именем - name1 добавлен в базу");
            userDao.saveUser("Name2", "LastName2", (byte) 25);
            System.out.println("User с именем - name2 добавлен в базу");
            userDao.saveUser("Name3", "LastName3", (byte) 31);
            System.out.println("User с именем - name3 добавлен в базу");
            userDao.saveUser("Name4", "LastName4", (byte) 38);
            System.out.println("User с именем - name4 добавлен в базу");

            userDao.removeUserById(1);    //++
            userDao.getAllUsers();
            System.out.println(userDao.getAllUsers().toString());
            userDao.cleanUsersTable();      //++
            userDao.dropUsersTable();    //++
        }
    }

