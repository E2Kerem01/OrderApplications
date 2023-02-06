package com.patika;

import java.time.LocalDate;
import java.util.List;


public class Invoice {
    private final int invoiceNumber;
    private final int amount;
    private final LocalDate date;
    private final Order order;


    public Invoice(int invoiceNumber, int amount, LocalDate date, Order order) {
        this.invoiceNumber = invoiceNumber;
        this.amount =  amount;
        this.date = date;
        this.order = order;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Order getOrder() {
        return order;
    }

    private static boolean isCustomersInvoince(Invoice c) throws InterruptedException {
        boolean customerFound;
        System.out.println( "Customer Name: "+c.getOrder().getCustomer().getFirstName() +"\n"+ "Customer ID: "
                + c.getOrder().getCustomer().getId() +"\n"+ "Invoince Number: "
                + c.getInvoiceNumber() +"\n"+ "Amount: " + c.getAmount() +"\n"
                +"Product Name: " +c.getOrder().getProductName() +"\n"+ "Invoince Date: " + c.getDate());
        System.out.println("-----------------------------" +"\n"+"\n"+"\n"+"\n");
        Thread.sleep(5000);
        customerFound = true;
        return customerFound;
    }


    /*public void getAvarageAmount(List<Invoice> invoices){
        double average = invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0.0);
    }*/

    /*public void getasdf(List<Invoice> invoices){
        List<Invoice> invoiceList = invoices;
        boolean customerFound = false;                          // Müşteri bulunup bulunmadığını tutan değişken
        for (Invoice c : invoiceList) {
            if (invoiceList.size()>0) {
                System.out.println( c.getOrder().getCustomer().getFirstName() + " " + c.getOrder().getCustomer().getId() + " "
                                + c.getInvoiceNumber() + " " + c.getAmount() + " " + c.getDate());
                        customerFound = true;
            }
        }

        if (!customerFound) {
            System.out.println("No customer found ...");
        }
    }*/

}
