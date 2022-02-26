package com.tw.rhea.wallet;

public class Owner implements WalletOwner {
    private double amountInDollar=0;

    @Override
    public void viewAmountInDollar(double amount) {
        amountInDollar=amount;
    }
}
