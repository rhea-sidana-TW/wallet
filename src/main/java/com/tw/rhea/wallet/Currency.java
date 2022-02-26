package com.tw.rhea.wallet;

public enum Currency {
    India_Rupee(1),
    US_Dollar(0.013);

    private final double conversionFactor;

    Currency(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertToBase(double amount) {
        return (amount * this.conversionFactor);
    }

    public double convertToUsDollar(double amount) {
        return (convertToBase(amount) / US_Dollar.conversionFactor);
    }
}
