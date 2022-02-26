package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.CreditMoneyLessThanOneException;
import com.tw.rhea.wallet.Exception.DebitMoneyGreaterThanWalletMoneyException;
import com.tw.rhea.wallet.Exception.WalletMoneyLessThanZeroException;

public class Wallet {
    private final Currency currency;
    private double money;

    public Wallet(double money, Currency currency) throws WalletMoneyLessThanZeroException {
        if (money < 0) throw new WalletMoneyLessThanZeroException();
        this.money = money;
        this.currency=currency;
    }

    public static Wallet createIndianRupeeWallet(double money) throws WalletMoneyLessThanZeroException {
        return new Wallet(money,Currency.India_Rupee);
    }

    public static Wallet createUSDollarWallet(double money) throws WalletMoneyLessThanZeroException {
        return new Wallet(money,Currency.US_Dollar);
    }

    public void credit(double amount) throws CreditMoneyLessThanOneException {
        if (amount < 1.0) throw new CreditMoneyLessThanOneException();
        this.money += amount;
    }

    public double checkBalance() {
        return this.money;
    }

    public void debit(double amount) throws DebitMoneyGreaterThanWalletMoneyException {
        if(this.money-amount<0) throw new DebitMoneyGreaterThanWalletMoneyException();
        this.money -= amount;
    }
}
