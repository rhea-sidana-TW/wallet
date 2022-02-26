package com.tw.rhea.wallet;

public class Owner implements WalletOwner {
    private boolean moneyCredited = false;

    @Override
    public void notifyMoneyCredited() {
        moneyCredited = true;
    }

    public boolean isMoneyCredited(){
        return moneyCredited;
    }
}
