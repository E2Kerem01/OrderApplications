package com.patika;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Customer {


    private int id;

    private String firstName;
    private String lastName;
    private LocalDate registrationDate;
    private String industry;
    private List<Invoice> invoices;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getIndustry() {
        return industry;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Customer(int id, String firstName, String lastName, LocalDate registrationDate, String industry) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.industry = industry;
        this.invoices = new ArrayList<>(invoices);
    }

}