package com.ifmo.bank;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {
    public static ConcurrentMap<Long, Account> accounts = new ConcurrentHashMap<>();

    public Account createAccount (long userId) {
        Account account = new Account(userId);
        accounts.put(userId, account);
        return account;
    }
    public double getAmount (long accountId) {
        double amount = 0;
        ArrayList<Account> list = new ArrayList<>(accounts.values());
        for (Account account : list) {
            if (account.getAccountId() == accountId) {
                amount = account.getAmount();
            } else {
                System.out.println("Account ID '" + accountId + "' not found");
            }
        }
        return amount;
    }

    public void blockAccount (long accountId) {}

    public boolean isAccountBlocked (long accountId) {
        return true;
    }

    public void changeAmount (long accountId, double amount) {
        ArrayList<Account> list = new ArrayList<>(accounts.values());
        for (Account account : list) {
            if (account.getAccountId() == accountId) {
                account.setAmount(account.getAmount() + amount);
            } else {
                System.out.println("Account ID '" + accountId + "' not found");
            }
        }
    }
    public static synchronized void transferMoney(long srcAccountId, long dstAccountId, double amount) {
        ArrayList<Account> list = new ArrayList<>(accounts.values());

        for (Account account : list) {

            if (account.getAccountId() == srcAccountId) {
                if (account.getAmount() >= amount) {
                    account.setAmount(account.getAmount() - amount);
                } else {
                    System.out.println("Not enough money");
                }
            }

            if (account.getAccountId() == dstAccountId) {
                account.setAmount(account.getAmount() + amount);
            }
        }
    }
}
