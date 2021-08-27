package lk.ijse.pos.dao;

import java.sql.*;
import java.util.ArrayList;

public class OrderDetailsDAOImpl {
    public boolean addOrderDetails(OrderDetails orderDetails) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetails  VALUES (?,?,?,?)");
        pstm.setObject(1, orderDetails.getOrderId());
        pstm.setObject(2, orderDetails.getItemCode());
        pstm.setObject(3, orderDetails.getQty());
        pstm.setObject(4, orderDetails.getUnitPrice());
        return (pstm.executeUpdate()>0);
    }

    public boolean deleteOrderDetails(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM OrderDetails  WHERE orderId=?");
        pstm.setObject(1, id);
        return (pstm.executeUpdate()>0);
    }

    public boolean updateOrderDetails(OrderDetails orderDetails) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE OrderDetails SET itemCode=?, qty=? , unitPrice=? WHERE orderId=?");
        pstm.setObject(1, orderDetails.getItemCode());
        pstm.setObject(2, orderDetails.getQty());
        pstm.setObject(3, orderDetails.getUnitPrice());
        pstm.setObject(4, orderDetails.getOrderId());
        return (pstm.executeUpdate()>0);
    }

    public OrderDetails searchOrderDetail(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM OrderDetails where orderId=?");
        if (rst.next()){
            return new OrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getBigDecimal(4));
        }
        return null;
    }

    public ArrayList<OrderDetails> getAllOrderDetails() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM OrderDetails");
        ArrayList<OrderDetails> allOrderDetails = new ArrayList<>();
        while (rst.next()) {
            allOrderDetails.add(new OrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getBigDecimal(4));
        }
        return allOrderDetails;
    }
}
