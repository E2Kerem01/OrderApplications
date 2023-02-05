package com.patika;




import java.time.LocalDate;


final public class Order {
    private String productName;
    private int quantity;
    private double price;
    private Customer customer;
    private LocalDate orderDate;

    public Order(String productName, int quantity, int price, Customer customer, LocalDate orderDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
