package com.ifmo.bank;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i=0; i<3; i++) {
            long userId = new Random().nextLong();
            bank.createAccount(userId);
//            Account account = Bank.accounts.get(userId);
//            System.out.println("Amount: " + bank.getAmount(account.getAccountId()));
        }
        Transfer transfer1 = Transfer.createAndStart("Transfer1");
        Transfer transfer2 = Transfer.createAndStart("Transfer2");
        Transfer transfer3 = Transfer.createAndStart("Transfer3");
    }
}
