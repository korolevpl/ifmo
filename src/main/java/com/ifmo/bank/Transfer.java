package com.ifmo.bank;

import java.util.ArrayList;
import java.util.Random;

public class Transfer implements Runnable {
    Thread thread;

    Transfer (String name) {
        this.thread = new Thread(this, name);
    }

    public static Transfer createAndStart(String name) {
        Transfer transfer = new Transfer(name);
        transfer.thread.start();
        return transfer;
    }

    @Override
    public void run() {
        ArrayList<Account> list = new ArrayList<>(Bank.accounts.values());
        ArrayList<Long> accountIds = new ArrayList();
        for (Account account : list) {
            account.getAccountId();
            accountIds.add(account.getAccountId());
        }
        for (int i=0; i<accountIds.size(); i++) {
            long srcAccount = accountIds.get(i);
            long dstAccount = accountIds.get(new Random().nextInt(accountIds.size()));
            Bank.transferMoney(srcAccount, dstAccount, 20);
        }

        for (Account account : list) {
            System.out.println(account.getAmount());
        }
    }
}
