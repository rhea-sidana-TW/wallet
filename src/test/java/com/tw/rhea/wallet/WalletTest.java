package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.CreditMoneyLessThanOneException;
import com.tw.rhea.wallet.Exception.DebitMoneyGreaterThanWalletMoneyException;
import com.tw.rhea.wallet.Exception.WalletMoneyLessThanZeroException;
import org.junit.jupiter.api.Test;

import static com.tw.rhea.wallet.Wallet.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsTwoHundred() throws CreditMoneyLessThanOneException, WalletMoneyLessThanZeroException {
        Wallet wallet = createIndianRupeeWallet(100);

        wallet.credit(200);
        double actualMoney = 300.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsLessThanOne() throws WalletMoneyLessThanZeroException {
        Wallet wallet = createIndianRupeeWallet(100);

        assertThrows(CreditMoneyLessThanOneException.class, () -> wallet.credit(0));
    }

    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsOne() throws CreditMoneyLessThanOneException, WalletMoneyLessThanZeroException {
        Wallet wallet = createIndianRupeeWallet(100);

        wallet.credit(1);
        double actualMoney = 101.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreateWalletWhenMoneyIsLessThanZero() {
        assertThrows(WalletMoneyLessThanZeroException.class, () -> createUSDollarWallet(-1));
    }

    @Test
    void shouldBeAbleToDebitMoneyOutTheWalletWhenWalletMoneyIsTwoHundredAndDebitedMoneyIsHundred() throws WalletMoneyLessThanZeroException, DebitMoneyGreaterThanWalletMoneyException {
        Wallet wallet = createIndianRupeeWallet(200);

        wallet.debit(100);
        double actualMoney = 100;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToDebitMoneyOutTheWalletWhenWalletMoneyIsHundredAndDebitedMoneyIsTwoHundred() throws WalletMoneyLessThanZeroException {
        Wallet wallet = createIndianRupeeWallet(100);

        assertThrows(DebitMoneyGreaterThanWalletMoneyException.class,()->wallet.debit(200));
    }

    @Test
    void shouldBeAbleToCreateIndianRupeeWallet() throws WalletMoneyLessThanZeroException {
        Wallet wallet = createIndianRupeeWallet(100);

        assertThat(100.0,is(closeTo(wallet.checkBalance(),0.001)));
    }

    @Test
    void shouldBeAbleToCreateUSDollarWallet() throws WalletMoneyLessThanZeroException {
        Wallet wallet = Wallet.createUSDollarWallet(100);

        assertThat(100.0,is(closeTo(wallet.checkBalance(),0.001)));
    }
}
