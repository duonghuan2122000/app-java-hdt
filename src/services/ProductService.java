/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import java.sql.SQLException;
import java.util.List;
import models.Product;

/**
 *
 * @author Jocelyn
 */
public class ProductService {
    private static ProductDao productDao = new ProductDaoImpl();
    
    public static List<Product> getAllProducts() throws SQLException{
        return productDao.getAllProducts();
    }
}
