/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Product;

/**
 *
 * @author Jocelyn
 */
public interface ProductDao {

    /**
     * get tat ca san pham
     *
     * @return List<Product>
     */
    List<Product> getAllProducts() throws SQLException;

//    /**
//     * tao mot san pham moi
//     * @param product
//     * @throws SQLException 
//     */
//    void createProduct(Product product) throws SQLException;
//
//    /**
//     * chinh sua mot san pham
//     * @param product
//     * @throws SQLException 
//     */
//    void updateProduct(Product product) throws SQLException;
}
