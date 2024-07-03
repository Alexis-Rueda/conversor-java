package com.currencyconverter.models;

public class ExchangePair {
    public String base;
    public String target;

    public ExchangePair(String base, String target) {
        this.base = base;
        this.target = target;
    }

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }
}
