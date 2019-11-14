/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.possystem.custom.CustomerDAO;
import lk.ijse.possystem.db.DBConnection;
import lk.ijse.possystem.dto.CustomerDTO;
import lk.ijse.possystem.entity.Customer;

/**
 *
 * @author LAHIRU SASANKA
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean add(Customer customer) throws Exception {
        Connection connection = DBConnection.getConnection();
        String SQL= "insert into customer values(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(SQL);
        pstm.setObject(1,customer.getId());
        pstm.setObject(2,customer.getName());
        pstm.setObject(3,customer.getAddress());
        pstm.setObject(4,customer.getSalary());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm=conn
                .prepareStatement("Update Customer set name=?,address=?,salary=? where id=?");
        pstm.setObject(1, customer.getName());
        pstm.setObject(2, customer.getAddress());
        pstm.setObject(3, customer.getSalary());
        pstm.setObject(4, customer.getId());
        return (pstm.executeUpdate()>0);
    }

    @Override
    public Customer find(String id) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from customer where id=?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
        if (rst!=null) {
            return new Customer(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("delete from customer where id=?");
        pstm.setObject(1, id);
        return (pstm.executeUpdate()>0);
    }

    @Override
    public List<Customer> findAll() throws Exception {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from customer");
        ResultSet rst = pstm.executeQuery();
        while(rst.next()){
            Customer cutDTO=new Customer(
                rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getDouble(4));
            allCustomers.add(cutDTO);
        }
        return allCustomers;
    }
}
