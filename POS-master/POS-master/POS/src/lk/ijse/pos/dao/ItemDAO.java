package lk.ijse.pos.dao;

import lk.ijse.pos.model.Item;
;

public interface ItemDAO extends SuperDAO <Item, String>{

    public boolean updateItemQtyOnHand(String code,int qtyOnHand) throws Exception;

}
