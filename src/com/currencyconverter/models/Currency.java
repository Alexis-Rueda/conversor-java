package com.currencyconverter.models;

public class Currency {

    String baseCode;
    String targetCode;
    double conversionRate;

    public Currency(CurrencyPair currencyPair) {
        this.baseCode = currencyPair.base_code();
        this.targetCode = currencyPair.target_code();
        this.conversionRate = currencyPair.conversion_rate();
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public String getBaseCode() {
        return baseCode;
    }

    @Override
    public String toString() {
        return "(baseCode=" + baseCode +
                ", targetCode=" + targetCode+
                ", conversionRate="+conversionRate+")";
    }
}
