package lk.ijse.pos.dao;

import lk.ijse.pos.model.OrderDetails;

import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO{

    @Override
    public boolean add(OrderDetails oDetails) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO OrderDetails VALUES (?,?,?,?)", oDetails.getOrderId(),oDetails.getItemCode(),oDetails.getQty(),oDetails.getUnitPrice());
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(OrderDetails orderDetails) throws Exception {
        return false;
    }

    @Override
    public OrderDetails search(String s) throws Exception {
        return null;
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws Exception {
        return null;
    }
}


//    public boolean addOrderDetails(OrderDetails oDetails) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO OrderDetails VALUES (?,?,?,?)");
//        pstm.setObject(1, oDetails.getOrderId());
//        pstm.setObject(2, oDetails.getItemCode());
//        pstm.setObject(3, oDetails.getQty());
//        pstm.setObject(4, oDetails.getUnitPrice());
//        return (pstm.executeUpdate() > 0);
//    }