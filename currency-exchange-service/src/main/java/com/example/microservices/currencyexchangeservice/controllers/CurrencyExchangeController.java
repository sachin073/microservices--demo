package com.example.microservices.currencyexchangeservice.controllers;

import com.example.microservices.currencyexchangeservice.models.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by sachin on 2/7/18.
 */

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

@GetMapping("/currency-exchange/from/{from}/to/{to}")
public ExchangeValue retrieveExchangedValue(@PathVariable String from, @PathVariable String to){
    ExchangeValue exchangeValue= new ExchangeValue(from,to,1L, BigDecimal.valueOf(69));

    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
    return exchangeValue;
}


    @Override
    public String toString() {
        return super.toString();
    }
}
