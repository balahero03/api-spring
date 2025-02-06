package com.NammaEvent.NammaEvent.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "service_provider")
public class service_provider {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_provider_id")
    private int service_provider_id;
    @Column(name = "service_provider_name")
    private String service_provider_name;
    @Column(name = "service_provider_address")
    private String service_provider_address;
    @Column(name = "service_provider_state")
    private String service_provider_state;
    @Column(name = "service_provider_district")
    private String service_provider_district;
    @Column(name = "service_provider_gender")
    private String service_provider_gender;
    @Column(name = "service_provider_phone_number")
    private BigInteger service_provider_phone_number;
    @Column(name = "service_provider_email")
    private String service_provider_email;
    @Column(name = "service_provider_password")
    private String service_provider_password;

    public service_provider(){

    }

    public service_provider(int service_provider_id, String service_provider_name, String service_provider_address, String service_provider_state, String service_provider_district, String service_provider_gender, BigInteger service_provider_phone_number, String service_provider_email, String service_provider_password) {
        this.service_provider_id = service_provider_id;
        this.service_provider_name = service_provider_name;
        this.service_provider_address = service_provider_address;
        this.service_provider_state = service_provider_state;
        this.service_provider_district = service_provider_district;
        this.service_provider_gender = service_provider_gender;
        this.service_provider_phone_number = service_provider_phone_number;
        this.service_provider_email = service_provider_email;
        this.service_provider_password = service_provider_password;
    }

    public int getService_provider_id() {
        return service_provider_id;
    }

    public void setService_provider_id(int service_provider_id) {
        this.service_provider_id = service_provider_id;
    }

    public String getService_provider_name() {
        return service_provider_name;
    }

    public void setService_provider_name(String service_provider_name) {
        this.service_provider_name = service_provider_name;
    }

    public String getService_provider_address() {
        return service_provider_address;
    }

    public void setService_provider_address(String service_provider_address) {
        this.service_provider_address = service_provider_address;
    }

    public String getService_provider_state() {
        return service_provider_state;
    }

    public void setService_provider_state(String service_provider_state) {
        this.service_provider_state = service_provider_state;
    }

    public String getService_provider_district() {
        return service_provider_district;
    }

    public void setService_provider_district(String service_provider_district) {
        this.service_provider_district = service_provider_district;
    }

    public String getService_provider_gender() {
        return service_provider_gender;
    }

    public void setService_provider_gender(String service_provider_gender) {
        this.service_provider_gender = service_provider_gender;
    }

    public BigInteger getService_provider_phone_number() {
        return service_provider_phone_number;
    }

    public void setService_provider_phone_number(BigInteger service_provider_phone_number) {
        this.service_provider_phone_number = service_provider_phone_number;
    }

    public String getService_provider_email() {
        return service_provider_email;
    }

    public void setService_provider_email(String service_provider_email) {
        this.service_provider_email = service_provider_email;
    }

    public String getService_provider_password() {
        return service_provider_password;
    }

    public void setService_provider_password(String service_provider_password) {
        this.service_provider_password = service_provider_password;
    }
}
