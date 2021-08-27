package lk.ijse.pos.dao;

import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl {
    public boolean addCustomer(Customer customer) throws Exception {
        String sql = "INSERT INTO Customer VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(sql, customer.getcID(), customer.getName(), customer.getAddress());
    }

    public boolean deleteCustomer(String id) throws Exception {
        String sql ="DELETE FROM Customer WHERE id=?";
        return CrudUtil.executeUpdate(sql, id);
    }

    public boolean updateCustomer(Customer customer) throws Exception {
        String sql = "UPDATE Customer SET name=?, address=? WHERE id=?";
        return CrudUtil.executeUpdate(sql, customer.getName(), customer.getAddress(), customer.getcID());
    }

    public Customer searchCustomer(String id) throws Exception {
        String sql = "select * from Customer where cId=?";
        ResultSet rst = CrudUtil.executeQuery(sql, id);
        if (rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomers() throws Exception {
        String sql = "SELECT * FROM Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Customer> alCustomers = new ArrayList<>();
        while (rst.next()){
            Customer customer= new Customer(rst.getString(1),rst.getString(2),rst.getString(3));
            alCustomers.add(customer);
        }
        return alCustomers;
    }
}
