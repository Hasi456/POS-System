/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.dao;

import lk.ijse.possystem.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.possystem.dao.custom.impl.ItemDAOImpl;
import lk.ijse.possystem.dao.custom.impl.QueryDAOImpl;

/**
 *
 * @author LAHIRU SASANKA
 */
public class DAOFactory {
    private static DAOFactory daoFactory;
    
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDER_DETAILS,QUERY
    }

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if (daoFactory == null) {
            daoFactory= new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case CUSTOMER : return new CustomerDAOImpl();
            case ITEM : return new ItemDAOImpl();
            case QUERY : return new QueryDAOImpl();
            default:return null;
        }
    }
}
