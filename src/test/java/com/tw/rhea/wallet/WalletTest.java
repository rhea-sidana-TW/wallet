package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.CreditMoneyLessThanOneException;
import com.tw.rhea.wallet.Exception.DebitMoneyGreaterThanWalletMoneyException;
import com.tw.rhea.wallet.Exception.WalletMoneyLessThanZeroException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsTwoHundred() throws CreditMoneyLessThanOneException, WalletMoneyLessThanZeroException {
        Wallet wallet = new Wallet(100);

        wallet.credit(200);
        double actualMoney = 300.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsLessThanOne() throws WalletMoneyLessThanZeroException {
        Wallet wallet = new Wallet(100);

        assertThrows(CreditMoneyLessThanOneException.class, () -> wallet.credit(0));
    }

    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsOne() throws CreditMoneyLessThanOneException, WalletMoneyLessThanZeroException {
        Wallet wallet = new Wallet(100);

        wallet.credit(1);
        double actualMoney = 101.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreateWalletWhenMoneyIsLessThanZero() {
        assertThrows(WalletMoneyLessThanZeroException.class, () -> new Wallet(-1));
    }

    @Test
    void shouldBeAbleToDebitMoneyOutTheWalletWhenWalletMoneyIsTwoHundredAndDebitedMoneyIsHundred() throws WalletMoneyLessThanZeroException, DebitMoneyGreaterThanWalletMoneyException {
        Wallet wallet = new Wallet(200);

        wallet.debit(100);
        double actualMoney = 100;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToDebitMoneyOutTheWalletWhenWalletMoneyIsHundredAndDebitedMoneyIsTwoHundred() throws WalletMoneyLessThanZeroException {
        Wallet wallet = new Wallet(100);

        assertThrows(DebitMoneyGreaterThanWalletMoneyException.class,()->wallet.debit(200));
    }
}
