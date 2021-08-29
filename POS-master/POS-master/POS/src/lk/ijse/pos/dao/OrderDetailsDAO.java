package lk.ijse.pos.dao;

import lk.ijse.pos.model.OrderDetails;

public interface OrderDetailsDAO {
    public boolean addOrderDetails(OrderDetails oDetails) throws Exception;
}
