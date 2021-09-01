package lk.ijse.pos.bo.impl;

import lk.ijse.pos.bo.custom.PurchaseOrderBO;
import lk.ijse.pos.controller.OrderFormController;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Item;
import lk.ijse.pos.model.OrderDetails;
import lk.ijse.pos.model.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    private final ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    private final OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
        public boolean purchaseOrder(Orders order, ArrayList<OrderDetails> orderDetails) throws Exception {
            Connection connection = null;
            try {
                connection = DBConnection.getInstance().getConnection();
                connection.setAutoCommit(false);
                boolean b1 = orderDAO.add(order);
                if (!b1) {
                    connection.rollback();
                    return false;
                }

                for (OrderDetails orderDetail : orderDetails) {
                    boolean b2 = orderDetailsDAO.add(orderDetail);
                    if (!b2) {
                        connection.rollback();
                        return false;
                    }


                    int qtyOnHand = 0;

                    Item item = itemDAO.search(orderDetail.getItemCode());

                    if (item != null) {
                        qtyOnHand = item.getQtyOnHand();
                    }

                    boolean b = itemDAO.updateItemQtyOnHand(orderDetail.getItemCode(), qtyOnHand - orderDetail.getQty());

                    if (!b) {
                        connection.rollback();
                        return false;
                    }
                }

                connection.commit();

            } catch (SQLException ex) {
                try {
                    connection.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.setAutoCommit(true);
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(OrderFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }

    }
