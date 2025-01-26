package com.NammaEvent.NammaEvent.model;

import jakarta.persistence.*;

import java.math.BigInteger;


@Entity
@Table(name = "customer")
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private int customerId;

    @Column(name = "customername")
    private String customerName ;

    @Column(name = "customerphonenumber")
    private BigInteger customerPhoneNumber;

    @Column(name = "customeremailid")
    private String customerEmailId;

    @Column(name = "customerpassword")
    private String customerPassword;

    public customer(int customerId, String customerName, BigInteger customerPhoneNumber, String customerEmailId, String customerPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerEmailId = customerEmailId;
        this.customerPassword = customerPassword;
    }

    public customer(){

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigInteger getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(BigInteger customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
}
