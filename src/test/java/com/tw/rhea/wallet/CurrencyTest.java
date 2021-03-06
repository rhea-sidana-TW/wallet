package com.tw.rhea.wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

public class CurrencyTest {
    @Test
    void shouldBeAbleToConvertRupeeToBase() {
        double rupeeToBase = Currency.India_Rupee.convertToBase(100);
        double actual = 100;

        assertThat(actual, is(closeTo(rupeeToBase, 0.001)));
    }

    @Test
    void shouldBeAbleToConvertUSDollarToBase() {
        double dollarToBase = Currency.US_Dollar.convertToBase(3);
        double actual = 225.18;

        assertThat(actual, is(closeTo(dollarToBase,0.001)));
    }

    @Test
    void shouldBeAbleToConvertIndianRupeeToUsDollar() {
        double rupeeToDollar = Currency.India_Rupee.convertToUsDollar(225.18);
        double actual = 3;

        assertThat(actual, is(closeTo(rupeeToDollar,0.001)));
    }

    @Test
    void shouldBeAbleToConvertUSDollarToUSDollar() {
        double dollarToDollar = Currency.US_Dollar.convertToUsDollar(3);
        double actual = 3;

        assertThat(actual, is(closeTo(dollarToDollar,0.001)));
    }
}
