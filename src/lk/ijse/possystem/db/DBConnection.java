/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LAHIRU SASANKA
 */
public class DBConnection {
    private static Connection connection;
    
    public static Connection getConnection() throws Exception{
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thogakade",
                    "root","19960913");
        }
        return connection;
    }
}
