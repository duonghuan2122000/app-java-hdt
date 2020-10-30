/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProductDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Product;

/**
 *
 * @author Jocelyn
 */
public class ProductDaoImpl extends UtilDao implements ProductDao {

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM tbl_SanPham";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("ten");
            double priceImport = rs.getDouble("giaNhap");
            double priceSale = rs.getDouble("giaBan");
            String producer = rs.getString("nhaSanXuat");
            Date expiryDate = rs.getDate("hanSuDung");
            int quantity = rs.getInt("soLuong");
            String description = rs.getString("moTa");
            Product product = new Product(id, name, priceImport, priceSale, producer, expiryDate, quantity, description);
            products.add(product);
        }
        return products;
    }
    
}
