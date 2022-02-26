package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.CreditMoneyLessThanOneException;
import com.tw.rhea.wallet.Exception.DebitMoneyGreaterThanWalletMoneyException;
import com.tw.rhea.wallet.Exception.WalletMoneyLessThanZeroException;
import org.junit.jupiter.api.Test;

import static com.tw.rhea.wallet.Wallet.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsTwoHundred() throws CreditMoneyLessThanOneException, WalletMoneyLessThanZeroException {
        WalletOwner owner = new Owner();
        Wallet wallet = createIndianRupeeWallet(100, owner);

        wallet.credit(200);
        double actualMoney = 300.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsLessThanOne() throws WalletMoneyLessThanZeroException {
        WalletOwner owner = new Owner();
        Wallet wallet = createIndianRupeeWallet(100, owner);

        assertThrows(CreditMoneyLessThanOneException.class, () -> wallet.credit(0));
    }

    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsOne() throws CreditMoneyLessThanOneException, WalletMoneyLessThanZeroException {
        WalletOwner owner = new Owner();
        Wallet wallet = createIndianRupeeWallet(100, owner);

        wallet.credit(1);
        double actualMoney = 101.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreateWalletWhenMoneyIsLessThanZero() {
        assertThrows(WalletMoneyLessThanZeroException.class, () -> createUSDollarWallet(-1, new Owner()));
    }

    @Test
    void shouldBeAbleToDebitMoneyOutTheWalletWhenWalletMoneyIsTwoHundredAndDebitedMoneyIsHundred() throws WalletMoneyLessThanZeroException, DebitMoneyGreaterThanWalletMoneyException {
        WalletOwner owner = new Owner();
        Wallet wallet = createIndianRupeeWallet(200, owner);

        wallet.debit(100);
        double actualMoney = 100;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToDebitMoneyOutTheWalletWhenWalletMoneyIsHundredAndDebitedMoneyIsTwoHundred() throws WalletMoneyLessThanZeroException {
        WalletOwner owner = new Owner();
        Wallet wallet = createIndianRupeeWallet(100, owner);

        assertThrows(DebitMoneyGreaterThanWalletMoneyException.class, () -> wallet.debit(200));
    }

    @Test
    void shouldBeAbleToCreateIndianRupeeWallet() throws WalletMoneyLessThanZeroException {
        WalletOwner owner = new Owner();
        Wallet wallet = createIndianRupeeWallet(100, owner);

        assertThat(100.0, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldBeAbleToCreateUSDollarWallet() throws WalletMoneyLessThanZeroException {
        WalletOwner owner = new Owner();
        Wallet wallet = createUSDollarWallet(100, owner);

        assertThat(100.0, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldBeAbleToNotifyWalletOwnerWhenMoneyCreditedInTheWallet() throws WalletMoneyLessThanZeroException, CreditMoneyLessThanOneException {
        WalletOwner owner = new Owner();
        Wallet wallet = createIndianRupeeWallet(300,owner);

        wallet.credit(100);

        assertTrue(((Owner)owner).isMoneyCredited());
    }

    @Test
    void shouldNotBeAbleToNotifyWalletOwnerWhenNoMoneyCreditedInTheWallet() throws WalletMoneyLessThanZeroException {
        WalletOwner owner = new Owner();
        Wallet indianRupeeWallet = createIndianRupeeWallet(300,owner);

        indianRupeeWallet.checkBalance();

        assertFalse(((Owner)owner).isMoneyCredited());
    }
}
