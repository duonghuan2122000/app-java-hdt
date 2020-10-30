/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import models.User;

/**
 *
 * @author Jocelyn
 */
public interface UserDao {
    /**
     * Get user bang username
     * @param username
     * @return User
     */
    User getUser(String username, String password) throws SQLException;
}
