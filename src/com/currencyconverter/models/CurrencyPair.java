package com.currencyconverter.models;

public record CurrencyPair(String base_code,
                           String target_code,
                           double conversion_rate) {
}
