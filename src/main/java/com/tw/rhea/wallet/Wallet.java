package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.CreditMoneyLessThanOneException;
import com.tw.rhea.wallet.Exception.DebitMoneyGreaterThanWalletMoneyException;
import com.tw.rhea.wallet.Exception.WalletMoneyLessThanZeroException;

public class Wallet {
    private final Currency currency;
    private final WalletOwner owner;
    private double money;

    private Wallet(double money, Currency currency, WalletOwner owner) throws WalletMoneyLessThanZeroException {
        if (money < 0) throw new WalletMoneyLessThanZeroException();
        this.money = money;
        this.currency = currency;
        this.owner = owner;
    }

    public static Wallet createIndianRupeeWallet(double money,WalletOwner owner) throws WalletMoneyLessThanZeroException {
        return new Wallet(money, Currency.India_Rupee,owner);
    }

    public static Wallet createUSDollarWallet(double money,WalletOwner owner) throws WalletMoneyLessThanZeroException {
        return new Wallet(money, Currency.US_Dollar,owner);
    }

    public void credit(double amount) throws CreditMoneyLessThanOneException {
        if (amount < 1.0) throw new CreditMoneyLessThanOneException();
        this.money += amount;
        owner.notifyMoneyCredited();
    }

    public double checkBalance() {
        return this.money;
    }

    public void debit(double amount) throws DebitMoneyGreaterThanWalletMoneyException {
        if (this.money - amount < 0) throw new DebitMoneyGreaterThanWalletMoneyException();
        this.money -= amount;
        owner.notifyMoneyDebited();
    }

    public double getAmountInDollar() {
        return (this.currency.convertToUsDollar(this.money));
    }
}
