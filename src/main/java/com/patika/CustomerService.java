package com.patika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {


    List<Customer> customers = new ArrayList<>();
    Map<Customer, List<Invoice>> invoices = new HashMap<>();



    public void addCustomer(Customer customer){

        customers.add(customer);
    }


    public void deleteCustomer(Customer customer){

        customers.remove(customer);
        invoices.remove(customer);

    }


    public void updateCustomer(Customer customer){

    }


    public List<Customer> listAllCustomers(){

        return customers;

    }


    public List<Invoice> listInvoicesByCustomer(Customer customer){

        return invoices.get(customer);

    }




}
