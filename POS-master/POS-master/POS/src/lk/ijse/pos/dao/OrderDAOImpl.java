package lk.ijse.pos.dao;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl {
    public boolean addOrder(Orders orders) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Orders VALUES (?,?,?)");
        pstm.setObject(1, orders.getId());
        pstm.setObject(2, orders.getDate());
        pstm.setObject(3, orders.getCustomerId());
        return (pstm.executeUpdate()>0);
    }

    public boolean deleteOrder(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Orders WHERE id=?");
        pstm.setObject(1, id);
        return (pstm.executeUpdate()>0);
    }

    public boolean updateOrder(Orders orders) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Orders SET date=?, customerId=? WHERE id=?");
        pstm.setObject(1, orders.getDate());
        pstm.setObject(2, orders.getCustomerId());
        pstm.setObject(3, orders.getId());
        return (pstm.executeUpdate()>0);
    }

    public Orders searchOrder(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Orders where id=?");
        if (rst.next()){
            return new Orders(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    public ArrayList<Orders> getAllOrders() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Orders");
        ArrayList<Orders> allOrders = new ArrayList<>();
        while (rst.next()) {
            allOrders.add(new Orders(rst.getString(1), rst.getString(2), rst.getString(3)));
        }

        return allOrders;
    }

}
