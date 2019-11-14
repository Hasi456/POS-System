/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.bo;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.possystem.custom.ItemDAO;
import lk.ijse.possystem.custom.impl.ItemDAOImpl;
import lk.ijse.possystem.dto.ItemDTO;
import lk.ijse.possystem.entity.Item;

/**
 *
 * @author LAHIRU SASANKA
 */
public class ItemBO {
    
    private static ItemDAO itemDAO = new ItemDAOImpl();
    
    public static boolean addItem(ItemDTO itemDTO) throws Exception{
        return itemDAO.add(new Item(
                itemDTO.getCode(),
                itemDTO.getDescription(),
                itemDTO.getUnitprice(),
                itemDTO.getQty()
        ));
    }
    
    public static boolean deleteItem(String code) throws Exception{
        return itemDAO.delete(code);
    }
    
    public static ItemDTO searchItem(String code) throws Exception{
        Item item = itemDAO.find(code);
        return new ItemDTO(
                item.getCode(),
                item.getDescription(),
                item.getUnitPrice(),
                item.getQtyOnHand()
        );
    }
    
    public static boolean updateItem(ItemDTO itemDTO) throws Exception{
        return itemDAO.update(new Item(
                itemDTO.getCode(),
                itemDTO.getDescription(),
                itemDTO.getUnitprice(),
                itemDTO.getQty()
        ));
    }
    
    public static List<ItemDTO> getAllItem() throws Exception{
        List<Item> allItem = itemDAO.findAll();
        List<ItemDTO> tempItem = new ArrayList<>();
        for (Item item : allItem) {
            tempItem.add(new ItemDTO(
                    item.getCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQtyOnHand()
            ));
        }
        return tempItem;
    }   
}
