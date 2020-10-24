/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ACER
 */
public class User {
//    private int stt;
    private String username, password;
    private int isAdmin;

    public User(String username, String password, int isAdmin) {
//        this.stt = stt;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    

    public String getPassword() {
        return password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }
    
    
}
