/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.TypeProductDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.TypeProduct;

/**
 *
 * @author Jocelyn
 */
public class TypeProductDaoImpl extends UtilDao implements TypeProductDao {

    @Override
    public List<TypeProduct> getTypeProducts() throws SQLException {
        List<TypeProduct> typeProducts = new ArrayList<>();
        String sql = "SELECT * FROM tbl_LoaiSanPham";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("ten");
            TypeProduct tp = new TypeProduct(id, name);
            typeProducts.add(tp);
        }
        return typeProducts;
    }

}
