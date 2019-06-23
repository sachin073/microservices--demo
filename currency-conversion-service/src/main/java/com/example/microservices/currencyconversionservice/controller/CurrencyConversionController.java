package com.example.microservices.currencyconversionservice.controller;

import com.example.microservices.currencyconversionservice.fiegnRestProxies.CurrencyConversionProxy;
import com.example.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sachin on 2/7/18.
 */
@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {


        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        uriVariables.put("from",from);

        ResponseEntity<CurrencyConversionBean> responseEntity
                = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversionBean.class,uriVariables);

        CurrencyConversionBean ccb =responseEntity.getBody();


        return new CurrencyConversionBean(ccb.getId(),from,to,ccb.getConversionMultiple(),quantity,quantity.multiply(ccb.getConversionMultiple()),ccb.getPort());
    }


    @Autowired
    CurrencyConversionProxy proxy;

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {


        CurrencyConversionBean ccb= proxy.retrieveExchangedValue(from,to);

        return new CurrencyConversionBean(ccb.getId(),from,to,ccb.getConversionMultiple(),quantity,quantity.multiply(ccb.getConversionMultiple()),ccb.getPort());
    }


}
