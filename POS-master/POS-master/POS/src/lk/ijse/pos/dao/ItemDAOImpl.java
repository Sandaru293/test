package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{

    @Override
    public boolean addItem(Item item) throws Exception {
        String sql = "INSERT INTO Item VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(sql, item.getCode(), item.getDescription(), item.getQtyOnHand(), item.getUnitPrice());
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        String sql = "DELETE FROM Item WHERE code=?";
        return CrudUtil.executeUpdate(sql, code);
    }

    @Override
    public boolean updateItem(Item item) throws Exception {
        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return CrudUtil.executeUpdate(sql, item.getDescription(), item.getQtyOnHand(), item.getUnitPrice(), item.getCode());
    }

    @Override
    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        String sql = "UPDATE Item SET qtyOnHand=? WHERE code=?";
        return CrudUtil.executeUpdate(sql, code ,qtyOnHand);
    }

    @Override
    public Item searchItem(String code) throws Exception {
        String sql = "select * from Item where code=?";
        ResultSet rst = CrudUtil.executeQuery(sql, code);
        if (rst.next()) {
            return new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3), rst.getInt(4));
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        String sql = "Select * from Item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)));
        }
        return allItems;
    }
}



//    public boolean addItem(Item item) throws Exception, SQLException {
//        String sql = "INSERT INTO Item VALUES (?,?,?,?)";
//        return CrudUtil.executeUpdate(sql, item.getCode(), item.getDescription(), item.getQtyOnHand(), item.getUnitPrice());
//    }
//
//    public boolean deleteItem(String code) throws Exception {
//        String sql = "DELETE FROM Item WHERE code=?";
//        return CrudUtil.executeUpdate(sql, code);
//    }
//
//    public boolean updateItem(Item item) throws Exception {
//        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
//        return CrudUtil.executeUpdate(sql, item.getDescription(), item.getQtyOnHand(), item.getUnitPrice(), item.getCode());
//    }
//
//    public boolean updateItemQtyOnHand(String code,int qtyOnHand) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET qtyOnHand=? WHERE code=?");
//        pstm.setObject(1, qtyOnHand);
//        pstm.setObject(2, code);
//        return (pstm.executeUpdate() > 0);
//    }
//
//    public Item searchItem(String code) throws Exception {
//        String sql = "select * from Item where code=?";
//        ResultSet rst = CrudUtil.executeQuery(sql, code);
//        if (rst.next()) {
//            return new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3), rst.getInt(4));
//        }
//        return null;
//    }
//
//    public ArrayList<Item> getAllItems() throws Exception {
//        String sql = "Select * from Item";
//        ResultSet rst = CrudUtil.executeQuery(sql);
//        ArrayList<Item> allItems = new ArrayList<>();
//        while (rst.next()) {
//            allItems.add(new Item(rst.getString(1),
//                    rst.getString(2),
//                    rst.getBigDecimal(3),
//                    rst.getInt(4)));
//        }
//        return allItems;
//    }