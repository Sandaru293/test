package lk.ijse.pos.dao;

import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO{


    @Override
    public boolean add(Orders o) throws Exception { ;
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        return CrudUtil.executeUpdate(sql, o.getId(),o.getDate(),o.getCustomerId());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        return false;
    }

    @Override
    public Orders search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        return null;
    }

//    @Override
//    public boolean deleteOrder() throws Exception {
//        return false;
//    }
//
//    @Override
//    public boolean updateOrder() throws Exception {
//        return false;
//    }
//
//    @Override
//    public Orders searchOrder() throws Exception {
//        return null;
//    }
//
//    @Override
//    public ArrayList<Orders> getAllOrders() throws Exception {
//        return null;
//    }
}


//    public boolean addOrder(Orders orders) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "INSERT INTO Orders VALUES (?,?,?)";
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setObject(1, orders.getId());
//        pstm.setObject(2, orders.getDate());
//        pstm.setObject(3, orders.getCustomerId());
//        return (pstm.executeUpdate() > 0);
//    }
//
//    public boolean deleteOrder() {
//        throw new UnsupportedOperationException("Not Implement");
//    }
//
//    public boolean updateOrder() {
//        throw new UnsupportedOperationException("Not Implement");
//    }
//
//    public Orders searchOrder() {
//        throw new UnsupportedOperationException("Not Implement");
//    }
//
//    public ArrayList<Orders> getAllOrders() {
//        throw new UnsupportedOperationException("Not Implement");
//    }