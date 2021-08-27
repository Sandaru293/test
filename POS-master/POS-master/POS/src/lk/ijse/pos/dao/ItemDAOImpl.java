package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl {
    public boolean addItem(Item item) throws Exception {
        String sql = "INSERT INTO Item VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(sql,item.getCode(),item.getDescription(),new BigDecimal(String.valueOf(item.getUnitPrice())),item.getQtyOnHand());
    }

    public boolean deleteItem(String id) throws Exception {
        String sql ="DELETE FROM Item WHERE code=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    public boolean updateItem(Item item) throws Exception {
        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return CrudUtil.executeUpdate(sql,item.getDescription(),new BigDecimal(String.valueOf(item.getUnitPrice())),item.getQtyOnHand(),item.getCode());
    }

    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        String sql = "UPDATE Item SET qtyOnHand=? WHERE code=?";
        return CrudUtil.executeUpdate(sql,qtyOnHand,code);

    }

    public Item searchItem(String id) throws Exception {
        String sql = "SELECT * FROM Item where code=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        if (rst.next()){
            return new Item(rst.getString(1),rst.getBigDecimal(2), rst.getInt(3), rst.getString(4));
        }
        return null;
    }

    public ArrayList<Item>getAllItems() throws Exception {
        String sql = "SELECT * FROM Item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Item> alItems = new ArrayList<>();
        while (rst.next()){
            Item item= new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3),rst.getInt(4));
            alItems.add(item);
        }
        return alItems;
    }
}
