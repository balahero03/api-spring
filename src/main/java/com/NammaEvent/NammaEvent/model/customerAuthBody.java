package com.NammaEvent.NammaEvent.model;

public class customerAuthBody {
    private String customeremailid;
    private String customerpassword;

    public customerAuthBody(){

    }

    public customerAuthBody(String customeremailid, String customerpassword) {
        this.customeremailid = customeremailid;
        this.customerpassword = customerpassword;
    }

    public String getcustomeremailid() {
        return customeremailid;
    }

    public void setcustomeremailid(String customeremailid) {
        this.customeremailid = customeremailid;
    }

    public String getcustomerpassword() {
        return customerpassword;
    }

    public void setcustomerpassword(String customerpassword) {
        this.customerpassword = customerpassword;
    }
}
