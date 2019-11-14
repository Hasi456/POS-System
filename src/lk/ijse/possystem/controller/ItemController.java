/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.possystem.controller;

import java.util.List;
import lk.ijse.possystem.business.ItemBusiness;
import lk.ijse.possystem.dto.ItemDTO;

/**
 *
 * @author LAHIRU SASANKA
 */
public class ItemController {
    
    public static boolean addItem(ItemDTO itemDTO) throws Exception{
        return ItemBusiness.addItem(itemDTO);
    }
    
    public static boolean deleteItem(String code) throws Exception{
        return ItemBusiness.deleteItem(code);
    }
    
    public static ItemDTO searchItem(String code) throws Exception{
        return ItemBusiness.searchItem(code);
    }
    
    public static boolean updateItem(ItemDTO itemDTO) throws Exception{
        return ItemBusiness.updateItem(itemDTO);
    }
    
    public static List<ItemDTO> getAllItem() throws Exception{
        return ItemBusiness.getAllItem();
    }
}
