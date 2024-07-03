package com.currencyconverter.currency;

import com.currencyconverter.models.Currency;
import com.currencyconverter.models.ExchangePair;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Conversor {

    public void showResult (ExchangePair exchangePair, double amount) {
        String base = exchangePair.getBase();
        String target = exchangePair.getTarget();
        Currency currency = new SearchCurrency().search(base, target);
        double result = currency.getConversionRate() * amount;

        String baseC = " [" + base + "] ";
        String targetC = " [" + target + "] ";
        String txt1 = "\nEl valor " + decimalFormat(amount) + baseC;
        String txt2 = "corresponde el valor final de =>>> " + decimalFormat(result) + targetC;

        System.out.println(txt1 + txt2);
    }

    private String decimalFormat(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(value);
    }
}
