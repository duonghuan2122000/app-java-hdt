/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.User;

/**
 *
 * @author Jocelyn
 */
public class Storage {
    private User user;
    private static final Storage INSTANCE = new Storage();
    
    private Storage(){
        this.user = new User();
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public static Storage getInstance(){
        return INSTANCE;
    }
}
