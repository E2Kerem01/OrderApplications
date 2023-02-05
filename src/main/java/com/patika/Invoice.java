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

    public void getAvarageAmount(List<Invoice> invoices){
        double average = invoices.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0.0);
    }

}
