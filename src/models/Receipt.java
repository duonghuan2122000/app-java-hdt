/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Jocelyn
 */
public class Receipt {
    private int id;
    private User user;
    private Date createdAt;
    private List<Pair<Integer, Product>> products;

    public Receipt() {
    }

    public Receipt(int id, User user, Date createdAt) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Receipt(List<Pair<Integer, Product>> products) {
        this.products = products;
    }

    public List<Pair<Integer, Product>> getProducts() {
        return products;
    }
    
    

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    
}
