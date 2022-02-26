package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.MoneyLessThanOneException;
import com.tw.rhea.wallet.Exception.WalletMoneyLessThanZeroException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditMoneyIsTwoHundred() throws MoneyLessThanOneException, WalletMoneyLessThanZeroException {
        Wallet wallet = new Wallet(100);

        wallet.credit(200);
        double actualMoney = 300.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsLessThanOne() throws WalletMoneyLessThanZeroException {
        Wallet wallet = new Wallet(100);

        assertThrows(MoneyLessThanOneException.class, () -> wallet.credit(0));
    }

    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditedMoneyIsOne() throws MoneyLessThanOneException, WalletMoneyLessThanZeroException {
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
    void shouldBeAbleToDebitMoneyOutTheWalletWhenWalletMoneyIsTwoHundredAndDebitedMoneyIsHundred() throws WalletMoneyLessThanZeroException {
        Wallet wallet = new Wallet(200);

        wallet.debit(100);
        double actualMoney = 100;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }
}
