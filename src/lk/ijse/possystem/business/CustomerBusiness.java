/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.possystem.dao.DAOFactory;
import lk.ijse.possystem.dao.custom.CustomerDAO;
import lk.ijse.possystem.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.possystem.db.DBConnection;
import lk.ijse.possystem.dto.CustomerDTO;
import lk.ijse.possystem.entity.Customer;

/**
 *
 * @author LAHIRU SASANKA
 */
public class CustomerBusiness {
    
    
    private static CustomerDAO customerDAO= (CustomerDAO)DAOFactory;
    
    public static boolean addCustomer(CustomerDTO customerDTO) throws Exception{
        return customerDAO.add(new Customer(
                customerDTO.getCid(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getSalary()
        ));
    }
    
    public static boolean deleteCustomer(String cid) throws Exception{
        return customerDAO.delete(cid);
    }
    
    public static CustomerDTO searchCustomer(String cid) throws Exception{
        Customer customer = customerDAO.find(cid);
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getSalary()
        );
    }
    
    public static boolean updateCustomer(CustomerDTO customerDTO) throws Exception{
        return customerDAO.update(new Customer(
                customerDTO.getCid(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getSalary()
        ));
    }
    
    public static List<CustomerDTO> getAllCustomer() throws Exception{
        List<Customer> allCustomer = customerDAO.findAll();
        List<CustomerDTO> tempDTO = new ArrayList<>();
        for (Customer customer : allCustomer) {
            tempDTO.add(
            new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getSalary()
            ));
        }
        return tempDTO;
    }
}
