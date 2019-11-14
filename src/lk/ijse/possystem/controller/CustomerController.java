/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import lk.ijse.possystem.business.CustomerBusiness;
import lk.ijse.possystem.db.DBConnection;
import lk.ijse.possystem.dto.CustomerDTO;

/**
 *
 * @author LAHIRU SASANKA
 */
public class CustomerController {
    
    public static boolean addCustomer(CustomerDTO customer) throws Exception{
        return CustomerBusiness.addCustomer(customer);
    }
    
    public static boolean deleteCustomer(String cid) throws Exception{
        return CustomerBusiness.deleteCustomer(cid);
    }
    
    public static CustomerDTO searchCustomer(String cid) throws Exception{
        return CustomerBusiness.searchCustomer(cid);
    }
    
    public static boolean updateCustomer(CustomerDTO customerDTO) throws Exception{
        return CustomerBusiness.updateCustomer(customerDTO);
    }
    
    public static List<CustomerDTO> getAllCustomer() throws Exception{
        return CustomerBusiness.getAllCustomer();
    }
}
