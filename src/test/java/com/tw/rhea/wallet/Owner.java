package com.tw.rhea.wallet;

public class Owner implements WalletOwner {
    private boolean moneyCredited = false;
    private boolean moneyDebited = false;


    @Override
    public void notifyMoneyDebited() {
        this.moneyDebited = true;
    }

    @Override
    public void notifyMoneyCredited() {
        this.moneyCredited = true;
    }

    public boolean isMoneyCredited() {
        return this.moneyCredited;
    }

    public boolean isMoneyDebited() {
        return this.moneyDebited;
    }
}
