package lk.ijse.pos.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl {
    public boolean addCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
        pstm.setObject(1, customer.getcID());
        pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, 0);
        return (pstm.executeUpdate()>0);
    }

    public boolean deleteCustomer(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setObject(1, id);
        return (pstm.executeUpdate()>0);

    }

    public boolean UpdateCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setObject(1, customer.getAddress());
        pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getcID());
        return (pstm.executeUpdate()>0);

    }

    public Customer searchCustomer(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer where id=?");
        if (rst.next()){
            return new Customer(rst.getString(1),rst.getString(2),rst.getString(3));
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<Customer> alCustomers = new ArrayList<>();
        while (rst.next()){
            Customer customer= new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
            alCustomers.add(customer);

        }
        return alCustomers;
    }
}
