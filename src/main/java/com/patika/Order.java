package com.patika;

import java.util.Date;
import java.util.List;

public class Order {
    private Date orderDate;
    private double amount;
    private List<String> products;

    public Order(Date orderDate, double amount, List<String> products) {
        this.orderDate = orderDate;
        this.amount = amount;
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}





/*import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class InvoiceSystem {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Invoice> invoices = new ArrayList<>();

    public static void main(String[] args) {
        // Tüm müşterileri listeleyin
        customers.stream().forEach(System.out::println);

        // Yeni Müşteri oluşturabilen
        Customer newCustomer = new Customer("John Doe", "john.doe@gmail.com", "Software", LocalDate.of(2022, 6, 1));
        customers.add(newCustomer);

        // İçerisinde ‘C’ harfi olan müşterileri listeleyin
        customers.stream()
                .filter(c -> c.getName().contains("C"))
                .forEach(System.out::println);

        // Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarını listeleyin
        double totalJuneInvoiceAmount = customers.stream()
                .filter(c -> c.getRegistrationDate().getMonth() == LocalDate.of(2022, 6, 1).getMonth())
                .flatMap(c -> c.getInvoices().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();
        System.out.println("Total June Invoice Amount: " + totalJuneInvoiceAmount);

        // Sistemdeki tüm faturaları listeleyin
        invoices.stream().forEach(System.out::println);

        // Sistemdeki 1500TL üstündeki faturaları listeleyin
        invoices.stream()
                .filter(i -> i.getAmount() > 1500)
                .forEach(System.out::println);

        // Sistemdeki 1500TL üstündeki faturaların ortalamasını hesaplayın
        double averageInvoiceAmount = invoices.stream()
                .filter(i -> i.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0.0);
        System.out.println("Average Invoice Amount: " + averageInvoiceAmount);

        // Sistemdeki 500TL altındaki faturalara sahip müşterilerin isimleri listeleyin
        List<String> customerNames = customers.stream()
                .filter(c -> c.getInvoices().stream()
                        .any
*/
