package com.mike.ecommerce.service;

import com.mike.ecommerce.model.CurrencyConversion;
import com.mike.ecommerce.repository.CurrencyConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import java.io.*;
//import okhttp3.*;

import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Service
public class ConversionRateUpdater {

    private final CurrencyConversionRepository workingCurrencyConversionRepository;

    @Autowired
    public ConversionRateUpdater(CurrencyConversionRepository workingCurrencyConversionRepository) {
        this.workingCurrencyConversionRepository = workingCurrencyConversionRepository;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void updateCurrenciesConversionRates() {
        List<CurrencyConversion> currencyConversionList = workingCurrencyConversionRepository.findAll();
        Iterator<CurrencyConversion> currencyIterator = currencyConversionList.listIterator();
        while (currencyIterator.hasNext()) {
//            api call for it

//            save incoming result
        }
    }

    public void callExcahngeRate(CurrencyConversion conversionToUpdate){

//        HttpBuilder
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//
//        Request request = new Request.Builder()
//                .url("https://api.apilayer.com/exchangerates_data/convert?to={to}&from={from}&amount={amount}")
//                .addHeader("apikey", "AKcCpH87DcONnwxNdZzjAY1auiBTHgLM")
//                .method("GET", })
//            .build();
//    Response response = client.newCall(request).execute();
//    System.out.println(response.body().string());
//}
//
//
//        return
    }

}
