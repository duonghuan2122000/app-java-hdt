/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Receipt;

/**
 *
 * @author Jocelyn
 */
public interface ReceiptDao {

    /**
     * get tat ca hoa don
     *
     * @return List<Receipt>
     * @throws SQLException
     */
    List<Receipt> getAllReceipts() throws SQLException;

    /**
     * get mot hoa don bang id
     *
     * @param id
     * @return Receipt
     * @throws SQLException
     */
    Receipt getReceipt(int id) throws SQLException;
    
    /**
     * them mot hoa don moi
     * @param receipt
     * @throws SQLException 
     */
    void createReceipt(Receipt receipt) throws SQLException;
}
