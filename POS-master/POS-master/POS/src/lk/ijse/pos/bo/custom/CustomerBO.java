package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.model.Customer;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(Customer customer) throws Exception ;

    public boolean deleteCustomer(String id) throws Exception ;

    public boolean updateCustomer(Customer customer) throws Exception ;

    public Customer searchCustomer(String id) throws Exception ;

    public ArrayList<Customer> getAllCustomers() throws Exception ;
}
