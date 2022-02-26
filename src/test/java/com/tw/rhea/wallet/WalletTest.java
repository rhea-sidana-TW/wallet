package com.tw.rhea.wallet;

import com.tw.rhea.wallet.Exception.MoneyLessThanOneException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldBeAbleToCreditMoneyInTheWalletWhenCreditMoenyIsTwoHundred() throws MoneyLessThanOneException{
        Wallet wallet = new Wallet(100);

        wallet.credit(200);
        double actualMoney = 300.0;

        assertThat(actualMoney, is(closeTo(wallet.checkBalance(), 0.001)));
    }

    @Test
    void shouldNotBeAbleToCreditMoneyWhenCreditedMoneyIsLessThanOne() {
        Wallet wallet = new Wallet(100);

        assertThrows(MoneyLessThanOneException.class,()->wallet.credit(0));
    }

    @Test
    void shouldBeAbleToCreditMoneyWhenCreditedMoneyIsOne() throws MoneyLessThanOneException {
        Wallet wallet = new Wallet(100);

        wallet.credit(1);
        double actualMoney = 101.0;

        assertThat(actualMoney,is(closeTo(wallet.checkBalance(),0.001)));
    }
}
