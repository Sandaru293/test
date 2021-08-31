package lk.ijse.pos.bo.impl.custom;

import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.util.ArrayList;

public interface PurchaseOrderBO {
    public boolean purchaseOrder(Orders order, ArrayList<OrderDetails> orderDetails) throws Exception ;
}
