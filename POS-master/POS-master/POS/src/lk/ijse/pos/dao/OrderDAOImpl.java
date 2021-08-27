package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Orders;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl {
    public boolean addOrder(Orders orders) throws Exception {
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        return CrudUtil.executeUpdate(sql,orders.getId(),orders.getDate(),orders.getCustomerId());
    }

    public boolean deleteOrder(String id) throws Exception {
        String sql ="DELETE FROM Orders WHERE id=?";
        return CrudUtil.executeUpdate(sql, id);

    }

    public boolean updateOrder(Orders orders) throws Exception {
        String sql = "UPDATE Orders SET date=?, customerId=? WHERE id=?";
        return CrudUtil.executeUpdate(sql,orders.getDate(),orders.getCustomerId(),orders.getId());
    }

    public Orders searchOrder(String id) throws Exception {
        String sql ="SELECT * FROM Orders where id=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        if (rst.next()){
            return new Orders(rst.getString(1),rst.getDate(2),rst.getString(3));
        }
        return null;
    }

    public ArrayList<Orders> getAllOrders() throws Exception {
        String sql = "SELECT * FROM Orders";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Orders> allOrders = new ArrayList<>();
        while (rst.next()) {
            allOrders.add(new Orders(rst.getString(1), rst.getDate(2), rst.getString(3)));
        }

        return allOrders;
    }

}
