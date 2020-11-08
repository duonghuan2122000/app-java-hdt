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
import models.TypeProduct;

/**
 *
 * @author Jocelyn
 */
public class ProductDaoImpl extends UtilDao implements ProductDao {
    
    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "select tbl_SanPham.id as product_id, \n"
                + "	tbl_SanPham.ten as product_name, \n"
                + "	tbl_SanPham.giaNhap as product_priceImport,\n"
                + "	tbl_SanPham.giaBan as product_priceSale,\n"
                + "	tbl_SanPham.nhaSanXuat as product_producer,\n"
                + "	tbl_SanPham.hanSuDung as product_expiryDate,\n"
                + "	tbl_SanPham.soLuong as product_quantity,\n"
                + "	tbl_SanPham.moTa as product_desc,\n"
                + "	tbl_LoaiSanPham.id as typeProduct_id,\n"
                + "	tbl_LoaiSanPham.ten as typeProduct_name\n"
                + "	from tbl_SanPham, tbl_LoaiSanPham where tbl_SanPham.idLoaiSanPham = tbl_LoaiSanPham.id";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            double priceImport = rs.getDouble("product_priceImport");
            double priceSale = rs.getDouble("product_priceSale");
            String producer = rs.getString("product_producer");
            Date expiryDate = rs.getDate("product_expiryDate");
            int quantity = rs.getInt("product_quantity");
            String description = rs.getString("product_desc");
            int typeProduct_id = rs.getInt("typeProduct_id");
            String typeProduct_name = rs.getString("typeProduct_name");
            TypeProduct typeProduct = new TypeProduct(typeProduct_id, typeProduct_name);
            Product product = new Product(id, name, priceImport, priceSale, producer, expiryDate, quantity, description, typeProduct);
            products.add(product);
        }
        return products;
    }
    
    @Override
    public void createProduct(Product product) throws SQLException {
        String sql = "INSERT INTO tbl_Sanpham (ten, giaNhap, giaBan, nhaSanXuat, hanSuDung, soLuong, moTa, idLoaiSanPham) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, product.getName());
        stmt.setDouble(2, product.getPriceImport());
        stmt.setDouble(3, product.getPriceSale());
        stmt.setString(4, product.getProducer());
        stmt.setDate(5, (java.sql.Date) product.getExpiryDate());
        stmt.setInt(6, product.getQuantity());
        stmt.setString(7, product.getDescription());
        stmt.setInt(8, product.getTypeProduct().getId());
        stmt.executeUpdate();
        
    }
    
    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE tbl_SanPham\n"
                + "   SET [ten] = ?\n"
                + "      ,[giaNhap] = ?\n"
                + "      ,[giaBan] = ?\n"
                + "      ,[nhaSanXuat] = ?\n"
                + "      ,[hanSuDung] = ?\n"
                + "      ,[soLuong] = ?\n"
                + "      ,[idLoaiSanPham] = ?\n"
                + "      ,[moTa] = ?\n"
                + " WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, product.getName());
        stmt.setDouble(2, product.getPriceImport());
        stmt.setDouble(3, product.getPriceSale());
        stmt.setString(4, product.getProducer());
        stmt.setDate(5, (java.sql.Date) product.getExpiryDate());
        stmt.setInt(6, product.getQuantity());
        stmt.setInt(7, product.getTypeProduct().getId());
        stmt.setString(8, product.getDescription());
        stmt.setInt(9, product.getId());
        stmt.executeUpdate();
    }

    @Override
    public void delProduct(Product product) throws SQLException {
        String sql = "DELETE FROM tbl_SanPham WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, product.getId());
        stmt.executeUpdate();
    }
    
}
