package com.patika;

import java.time.LocalDate;
import java.util.Date;

public class Invoice {
    private LocalDate invoiceDate;
    private double amount;
    private Order order;

    public Invoice(LocalDate invoiceDate, double amount, Order order) {
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.order = order;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
