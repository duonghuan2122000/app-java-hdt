/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.User;
import utils.Const;

/**
 *
 * @author ACER
 */
public class Services {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(Const.DB_URL, Const.USER_NAME, Const.PASSWORD);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("connect failure!");
        }
        return conn;
    }
    public static User getUserbyName(String name) throws SQLException{
        User userlogin = new User();
        Connection connection = getConnection();
        
        String sql = "SELECT * FROM tbl_User WHERE userName = '" + name + "';";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
        int id = rs.getInt(1);
        String username = rs.getString(2);
        String pass = rs.getString(3);
        int isAdmin = rs.getInt(4);
        userlogin = new User(username, pass, isAdmin);  
        }
        
        connection.close();
        ps.close();
        rs.close();
        return userlogin;
    }
    public static boolean checkLogin(String name,String pass) throws SQLException{
        boolean check = false;
        if(pass.equals(getUserbyName(name).getPassword())){
            check = true;
        }       
        return check;
    }
}
