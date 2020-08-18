package com.mohamed.projectapplication;

public class Accounts {
    private String userId;
    private Integer total_fees;
    private Integer paid;
    private Integer balance;

    public Accounts() {
    }

    public Accounts(String userId, Integer total_fees, Integer paid, Integer balance) {
        this.userId = userId;
        this.total_fees = total_fees;
        this.paid = paid;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTotal_fees() {
        return total_fees;
    }

    public void setTotal_fees(Integer total_fees) {
        this.total_fees = total_fees;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getBalance() {
        this.balance = this.total_fees - this.paid;
        return balance;
    }

}
