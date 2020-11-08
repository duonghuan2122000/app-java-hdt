/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.ReceiptDao;
import dao.impl.ReceiptDaoImpl;
import java.sql.SQLException;
import java.util.List;
import models.Receipt;

/**
 *
 * @author Jocelyn
 */
public class ReceiptService {
    private static ReceiptDao receiptDao = new ReceiptDaoImpl();
    
    public static List<Receipt> getAllReceipts() throws SQLException {
        return receiptDao.getAllReceipts();
    }
    
    public static Receipt getReceipt(int id) throws SQLException {
        return receiptDao.getReceipt(id);
    }
}
