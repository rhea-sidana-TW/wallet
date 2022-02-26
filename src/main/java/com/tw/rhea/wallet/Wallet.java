package com.tw.rhea.wallet;

public class Wallet {
    private double money;

    public Wallet(double money) {
        this.money = money;
    }

    public void credit(double money) {
        this.money += money;
    }

    public double checkBalance() {
        return this.money;
    }
}
