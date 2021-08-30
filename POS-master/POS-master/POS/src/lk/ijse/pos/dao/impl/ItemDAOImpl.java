package lk.ijse.pos.dao.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.model.Item;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item i) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES (?,?,?,?)", i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice());
    }

    @Override
    public boolean delete(String code) throws Exception {
        String sql = "DELETE FROM Item WHERE code=?";
        return CrudUtil.executeUpdate(sql, code);
    }

    @Override
    public boolean update(Item i) throws Exception {
        String sql = "UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return CrudUtil.executeUpdate(sql, i.getDescription(), i.getQtyOnHand(), i.getUnitPrice(), i.getCode());
    }

    @Override
    public boolean updateItemQtyOnHand(String code, int qtyOnHand) throws Exception {
        String sql = "UPDATE Item SET qtyOnHand=? WHERE code=?";
        return CrudUtil.executeUpdate(sql, code ,qtyOnHand);
    }

    @Override
    public Item search(String code) throws Exception {
        String sql = "select * from Item where code=?";
        ResultSet rst = CrudUtil.executeQuery(sql, code);
        if (rst.next()) {
            return new Item(rst.getString(1),rst.getString(2),rst.getBigDecimal(3), rst.getInt(4));
        }
        return null;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        String sql = "Select * from Item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)));
        }
        return allItems;
    }
}
