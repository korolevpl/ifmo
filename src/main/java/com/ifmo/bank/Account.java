package com.ifmo.bank;

public class Account {
    private long accountId;
    private double amount;
    private long userId;
    private boolean blocked;

    public Account(long userId) {
        this.accountId = this.hashCode();
        this.amount = 100.0;
        this.userId = userId;
        this.blocked = false;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public long getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
