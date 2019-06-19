package com.example.microservices.currencyconversionservice.controller;

import com.example.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * Created by sachin on 2/7/18.
 */
@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {


        ResponseEntity<CurrencyConversionBean> responseEntity= new RestTemplate().getForEntity("http://localhost:8083/currency-exchange/from/EUR/to/INR",CurrencyConversionBean.class);

        CurrencyConversionBean ccb =responseEntity.getBody();


        return new CurrencyConversionBean(1L,from,to,ccb.getConversionMultiple(),quantity,quantity,0);


    }
}
