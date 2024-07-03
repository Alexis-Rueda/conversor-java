package com.currencyconverter.currency;

import com.currencyconverter.api.ApiInfo;
import com.currencyconverter.models.Currency;
import com.currencyconverter.models.CurrencyPair;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchCurrency {

    public Currency search(String base, String target) {
        String apiUrl = new ApiInfo().apiUrl + "/" + base + "/" + target;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            CurrencyPair currencyPair = gson.fromJson(response.body(), CurrencyPair.class);
            return new Currency(currencyPair);
        }  catch (Exception e){
            throw new RuntimeException("Moneda no encontrada");
        }
    }
}
