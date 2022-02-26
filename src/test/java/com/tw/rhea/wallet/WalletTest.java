package com.tw.rhea.wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

public class WalletTest {
    @Test
    void shouldBeAbleToCreditMoneyInTheWallet() {
        Wallet wallet = new Wallet(100);

        wallet.credit(200);
        double actual = 300.0;

        assertThat(actual, is(closeTo(wallet.checkBalance(), 0.001)));
    }
}
