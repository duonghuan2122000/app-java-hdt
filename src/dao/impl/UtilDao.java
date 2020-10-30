/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import java.sql.Connection;
import utils.Database;

/**
 *
 * @author Jocelyn
 */
public class UtilDao {
    protected Connection conn;

    public UtilDao() {
        conn = Database.getInstance().getConnection();
    }
    
    
}
