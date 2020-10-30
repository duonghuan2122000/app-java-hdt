/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UserDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;

/**
 *
 * @author Jocelyn
 */
public class UserDaoImpl extends UtilDao implements UserDao {

    @Override
    public User getUser(String username, String password) throws SQLException {
        User user = new User();
        String sql = "SELECT * FROM tbl_User WHERE userName = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            int isAdmin = rs.getInt("isAdmin");
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setIsAdmin(isAdmin);
           
            return user;
        }

//        conn.close();
        return user;
    }

}
