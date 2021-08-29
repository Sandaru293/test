package lk.ijse.pos.dao;

import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public interface OrderDAO {
    public boolean addOrder(Orders orders) throws Exception;

    public boolean deleteOrder()throws Exception;

    public boolean updateOrder() throws Exception;

    public Orders searchOrder() throws Exception;

    public ArrayList<Orders> getAllOrders() throws Exception;
}
