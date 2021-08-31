package lk.ijse.pos.bo.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.model.Item;

import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    //private final ItemDAO itemDAO =new ItemDAOImpl();
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addItem(Item item) throws Exception {
        return itemDAO.add(item);
    }
    @Override
    public boolean deleteItem(String code) throws Exception {
        return itemDAO.delete(code);
    }
    @Override
    public boolean updateItem(Item item) throws Exception {
        return itemDAO.update(item);
    }
    @Override
    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        return itemDAO.updateItemQtyOnHand(code,qtyOnHand);
    }
    @Override
    public Item searchItem(String code) throws Exception {
        return itemDAO.search(code);
    }
    @Override
    public ArrayList<Item> getAllItems() throws Exception {
        return itemDAO.getAll();
    }
}
