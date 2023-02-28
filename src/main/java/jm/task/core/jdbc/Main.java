package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

            UserServiceImpl userService = new UserServiceImpl();

            userService.createUsersTable(); //++

            userService.saveUser("Name1", "LastName1", (byte) 20);  //++
            System.out.println("User с именем - name1 добавлен в базу");
            userService.saveUser("Name2", "LastName2", (byte) 25);
            System.out.println("User с именем - name2 добавлен в базу");
            userService.saveUser("Name3", "LastName3", (byte) 31);
            System.out.println("User с именем - name3 добавлен в базу");
            userService.saveUser("Name4", "LastName4", (byte) 38);
            System.out.println("User с именем - name4 добавлен в базу");

            userService.removeUserById(1);    //++
            userService.getAllUsers();
            System.out.println(userService.getAllUsers().toString());
            userService.cleanUsersTable();      //++
            userService.dropUsersTable();    //++
        }
    }

