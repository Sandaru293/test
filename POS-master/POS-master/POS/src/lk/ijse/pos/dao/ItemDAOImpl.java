package lk.ijse.pos.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl {
    public boolean addItem(Item item) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");
        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, new BigDecimal(item.getUnitPrice()));
        pstm.setObject(4, Integer.parseInt(item.getQtyOnHand()));
        return (pstm.executeUpdate()>0);
    }

    public boolean deleteItem(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setObject(1, id);
        return (pstm.executeUpdate()>0);

    }

    public boolean updateItem(Item item) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setObject(1, item.getDescription());
        pstm.setObject(2, new BigDecimal(item.getUnitPrice()));
        pstm.setObject(3, Integer.parseInt(item.getQtyOnHand()));
        pstm.setObject(4, item.getCode());
        return (pstm.executeUpdate()>0);

    }

    public Item searchItem(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item where code=?");
        if (rst.next()){
            return new Item(rst.getString("code"),rst.getBigDecimal("description"),rst.getInt("unitPrice"),rst.getString("qtyOnHand"));
        }
    }

    public ArrayList<Item>getAllItems() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<ItemTM> alItems = new ArrayList<>();
        while (rst.next()){
            Item item= new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4));
            alItems.add(item);
        }
        return alItems;
    }
}
