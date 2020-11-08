/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ACER
 */
public class User {
//    private int stt;

    private int id;
    private String username, password;
    private int isAdmin;

    public User(int id, String username, String password, int isAdmin) {
//        this.stt = stt;
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }
    
    

    public User() {
        this(0, "", "", 0);
    }
    
    public boolean isEmpty(){
        return this.id == 0 || this.username.isEmpty() || this.password.isEmpty();
    }

    public String getPassword() {
        return password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public String getUsername(){
        return username;
    }

    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + '}';
    }
    
    

}
