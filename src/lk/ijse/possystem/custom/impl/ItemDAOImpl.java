/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.possystem.custom.ItemDAO;
import lk.ijse.possystem.db.DBConnection;
import lk.ijse.possystem.entity.Item;

/**
 *
 * @author LAHIRU SASANKA
 */
public class ItemDAOImpl implements ItemDAO{

    @Override
    public boolean add(Item item) throws Exception {
        Connection connection = DBConnection.getConnection();
        String SQL= "insert into item values(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(SQL);
        pstm.setObject(1,item.getCode());
        pstm.setObject(2,item.getDescription());
        pstm.setObject(3,item.getUnitPrice());
        pstm.setObject(4,item.getQtyOnHand());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean update(Item item) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm=conn
                .prepareStatement("Update item set description=?,unitPrice=?,qtyOnHand=? where code=?");
        
        pstm.setObject(1, item.getDescription());
        pstm.setObject(2, item.getUnitPrice());
        pstm.setObject(3, item.getQtyOnHand());
        pstm.setObject(4, item.getCode());
        return (pstm.executeUpdate()>0);
    }

    @Override
    public Item find(String code) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from item where code=?");
        pstm.setObject(1, code);
        ResultSet rst = pstm.executeQuery();
        if (rst!=null) {
            return new Item(
                rst.getString(1),
                rst.getString(2),
                rst.getDouble(3),
                rst.getInt(4)
            );
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("delete from item where code=?");
        pstm.setObject(1, id);
        return (pstm.executeUpdate()>0);
    }

    @Override
    public List<Item> findAll() throws Exception {
        ArrayList<Item> allItems = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Item");
        ResultSet rst = pstm.executeQuery();
        while(rst.next()){
            Item item=new Item(
                rst.getString(1),
                rst.getString(2),
                rst.getDouble(3),
                rst.getInt(4)
            );
            allItems.add(item);
        }
        return allItems;
    }
}
