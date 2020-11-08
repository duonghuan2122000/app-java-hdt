/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TypeProductDao;
import dao.impl.TypeProductDaoImpl;
import java.sql.SQLException;
import java.util.List;
import models.TypeProduct;

/**
 *
 * @author Jocelyn
 */
public class TypeProductService {
    private static TypeProductDao typeProductDao = new TypeProductDaoImpl();
    
    public static List<TypeProduct> getTypeProducts() throws SQLException{
        return typeProductDao.getTypeProducts();
    }
}
