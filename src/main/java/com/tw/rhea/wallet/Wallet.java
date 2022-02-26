package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.MoneyLessThanOneException;

public class Wallet {
    private double money;

    public Wallet(double money) {
        this.money = money;
    }

    public void credit(double money) throws MoneyLessThanOneException {
        if(money<1.0) throw new MoneyLessThanOneException();
        this.money += money;
    }

    public double checkBalance() {
        return this.money;
    }
}
