package com.example.microservices.limitservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by sachin on 1/7/18.
 */


@Component
@ConfigurationProperties("limit-service")
public class LoadConfiguration {

    private int max;

    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
