/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import java.sql.SQLException;
import models.User;

/**
 *
 * @author ACER
 */
public class UserService {

    private static UserDao userDao = new UserDaoImpl();

    /**
     * Get user
     *
     * @param username
     * @return User
     * @throws SQLException
     */
    public static User getUser(String username, String password) throws SQLException {
        return userDao.getUser(username, password);
    }
}
