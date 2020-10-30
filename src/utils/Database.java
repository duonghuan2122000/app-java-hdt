/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jocelyn
 */
public class Database {
    private static final Database INSTANCE = new Database();
    private Connection conn;

    private Database() {
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(Const.DB_URL, Const.USER_NAME, Const.PASSWORD);
//                System.out.println("connect successfully!");
            } catch (ClassNotFoundException | SQLException ex) {
//                ex.printStackTrace();
//                System.out.println("connect failure!");
            }
        }
    }
    
    public static Database getInstance(){
        return INSTANCE;
    } 
    
    public Connection getConnection(){
        return conn;
    }

}
