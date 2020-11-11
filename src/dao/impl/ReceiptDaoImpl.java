/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ReceiptDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.util.Pair;
import models.Product;
import models.Receipt;
import models.User;

/**
 *
 * @author Jocelyn
 */
public class ReceiptDaoImpl extends UtilDao implements ReceiptDao {

    @Override
    public List<Receipt> getAllReceipts() throws SQLException {
        List<Receipt> receipts = new ArrayList<>();
        String sql = "select tbl_HoaDon.id as receipt_id, \n"
                + "tbl_User.id as user_id, \n"
                + "tbl_User.userName as user_username, \n"
                + "tbl_HoaDon.ngayTao as receipt_createdAt\n"
                + "from tbl_HoaDon, tbl_User where tbl_HoaDon.idUser = tbl_User.id";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int receipt_id = rs.getInt("receipt_id");
            int user_id = rs.getInt("user_id");
            String user_username = rs.getString("user_username");
            Date receipt_createdAt = rs.getDate("receipt_createdAt");
            User user = new User(user_id, user_username);
            Receipt receipt = new Receipt(receipt_id, user, receipt_createdAt);
            receipts.add(receipt);
        }
        return receipts;
    }

    @Override
    public Receipt getReceipt(int id) throws SQLException {
        String sql = "select tbl_Contain.soLuong as soluong,\n"
                + "	tbl_SanPham.ten as p_name,\n"
                + "	tbl_SanPham.giaBan as p_priceSale\n"
                + "from tbl_Contain, tbl_SanPham, tbl_HoaDon\n"
                + "where tbl_HoaDon.id = tbl_Contain.idHoaDon and tbl_Contain.idSanPham = tbl_SanPham.id and tbl_HoaDon.id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        List<Pair<Integer, Product>> products = new ArrayList<>();
        while(rs.next()){
            int soluong = rs.getInt("soluong");
            String p_name = rs.getString("p_name");
            double p_priceSale = rs.getDouble("p_priceSale");
            Product product = new Product(p_name, p_priceSale);
            products.add(new Pair<Integer, Product>(soluong, product));
        }
        Receipt receipt = new Receipt(products);
        return receipt;
    }

    @Override
    public void createReceipt(Receipt receipt) throws SQLException {
        String sql_receipt = "insert into tbl_HoaDon (idUser, ngayTao) VALUES (?, ?)";
        PreparedStatement stmt_receipt = conn.prepareStatement(sql_receipt, Statement.RETURN_GENERATED_KEYS);
        stmt_receipt.setInt(1, receipt.getUser().getId());
        stmt_receipt.setDate(2, (java.sql.Date) receipt.getCreatedAt());
        int affectedRows = stmt_receipt.executeUpdate();
        if(affectedRows == 0){
            throw new SQLException("insert fail");
        }
        ResultSet rs = stmt_receipt.getGeneratedKeys();
        if(!rs.next()){
            throw new SQLException("insert fail");
        }
        int id = rs.getInt(1);
        System.out.println(id);
        StringBuilder builder = new StringBuilder("insert into tbl_Contain (idHoaDon, idSanPham, soLuong) VALUES");
        for(Pair<Integer, Product> p: receipt.getProducts()){
            builder.append(" (?, ?, ?),");
        }
        
        PreparedStatement stmt_contain = conn.prepareStatement(builder.deleteCharAt(builder.length() - 1).toString());
        int i = 1;
        for(Pair<Integer, Product> p: receipt.getProducts()){
            stmt_contain.setInt(i, id);
            stmt_contain.setInt(i+1, p.getValue().getId());
            stmt_contain.setInt(i+2, p.getKey());
            i += 3;
        }
        stmt_contain.executeUpdate();
    }

}
