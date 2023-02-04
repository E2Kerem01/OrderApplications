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
    private LocalDate registrationDate;
    private String industry;


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


    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Customer(int id,String firstName,  String industry, LocalDate registrationDate) {
        this.id = id;
        this.firstName = firstName;
        this.registrationDate = registrationDate;
        this.industry = industry;
    }



}