package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer c) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?)", c.getcID(),c.getName(),c.getAddress(),0);
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM Customer WHERE id=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    @Override
    public boolean update(Customer c) throws Exception {
        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
        return CrudUtil.executeUpdate(sql, c.getName(),c.getAddress(),c.getcID());
    }

    @Override
    public Customer search(String id) throws Exception {
        String sql = "select * from Customer where id=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        if (rst.next()) {
            return new Customer(rst.getString(1), rst.getString(2), rst.getString(3));
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        String sql = "SELECT * FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Customer> allCustomers = new ArrayList<>();//CustomerTM
        while (rst.next()) {
            Customer customer =new Customer(rst.getString(1), rst.getString(2), rst.getString(3));
            allCustomers.add(customer);
        }
        return allCustomers;
    }
//    @Override
//    public boolean addCustomer(Customer customer) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
//        pstm.setObject(1, customer.getcID());
//        pstm.setObject(2, customer.getName());
//        pstm.setObject(3, customer.getAddress());
//        pstm.setObject(4, 0);
//        return pstm.executeUpdate() > 0;
////        String sql = "INSERT INTO Customer VALUES (?,?,?)";
////        return CrudUtil.executeUpdate(sql, customer.getcID(),customer.getName(),customer.getAddress());
//    }
//
//    @Override
//    public boolean deleteCustomer(String id) throws Exception {
//        String sql = "DELETE FROM Customer WHERE id=?";
//        return CrudUtil.executeUpdate(sql, id);
//    }
//
//    @Override
//    public boolean updateCustomer(Customer customer) throws Exception {
//        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
//        return CrudUtil.executeUpdate(sql, customer.getName(),customer.getAddress(),customer.getcID());
//    }
//
//    @Override
//    public Customer searchCustomer(String id) throws Exception {
//        String sql = "select * from Customer where id=?";
//        ResultSet rst = CrudUtil.executeQuery(sql, id);
//        if (rst.next()) {
//            return new Customer(rst.getString(1), rst.getString(2), rst.getString(3));
//        }
//        return null;
//    }
//
//    @Override
//    public ArrayList<Customer> getAllCustomers() throws Exception {
//        String sql = "SELECT * FROM Customer";
//        ResultSet rst = CrudUtil.executeQuery(sql);
//        ArrayList<Customer> allCustomers = new ArrayList<>();//CustomerTM
//        while (rst.next()) {
//            Customer customer =new Customer(rst.getString(1), rst.getString(2), rst.getString(3));
//            allCustomers.add(customer);
//        }
//        return allCustomers;
//    }

}

