package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.CreditMoneyLessThanOneException;
import com.tw.rhea.wallet.Exception.WalletMoneyLessThanZeroException;

public class Wallet {
    private double money;

    public Wallet(double money) throws WalletMoneyLessThanZeroException {
        if (money < 0) throw new WalletMoneyLessThanZeroException();
        this.money = money;
    }

    public void credit(double amount) throws CreditMoneyLessThanOneException {
        if (amount < 1.0) throw new CreditMoneyLessThanOneException();
        this.money += amount;
    }

    public double checkBalance() {
        return this.money;
    }

    public void debit(double amount) {
        this.money -= amount;
    }
}
