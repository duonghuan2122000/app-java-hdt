/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Jocelyn
 */
public class Product {

    private int id;
    private String name;
    private double priceImport;
    private double priceSale;
    private String producer;
    private Date expiryDate;
    private int quantity;
    private String description;

    public Product(int id, String name, double priceImport, double priceSale, String producer, Date expiryDate, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.priceImport = priceImport;
        this.priceSale = priceSale;
        this.producer = producer;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPriceImport() {
        return priceImport;
    }

    public double getPriceSale() {
        return priceSale;
    }

    public String getProducer() {
        return producer;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    
}
