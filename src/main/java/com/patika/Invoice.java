package com.patika;

import java.time.LocalDate;
import java.util.List;


public class Invoice {
    private final int invoiceNumber;
    private final int amount;
    private final LocalDate date;
    private final Order order;
    private Customer customer;

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
