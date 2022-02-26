package com.tw.rhea.wallet;

public enum Currency {
    India_Rupee(1),
    US_Dollar(0.013);

    private final double conversionFactor;

    Currency(double conversionFactor){
        this.conversionFactor=conversionFactor;
    }
}
