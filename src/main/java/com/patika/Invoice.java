package com.patika;

import java.time.LocalDate;



public class Invoice {
    private final int invoiceNumber;
    private final double amount;
    private final LocalDate date;
    private final Order order;

    public Invoice(int invoiceNumber, double amount, LocalDate date, Order order) {
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.date = date;
        this.order = order;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Order getOrder() {
        return order;
    }
}
