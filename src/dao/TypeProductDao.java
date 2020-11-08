/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.TypeProduct;

/**
 *
 * @author Jocelyn
 */
public interface TypeProductDao {

    List<TypeProduct> getTypeProducts() throws SQLException;
}
