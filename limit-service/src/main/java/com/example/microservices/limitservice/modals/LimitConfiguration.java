package com.example.microservices.limitservice.modals;

/**
 * Created by sachin on 1/7/18.
 */
public class LimitConfiguration {

    private int max=99;

    private int min = 0;

    protected LimitConfiguration(){

    }

    public LimitConfiguration(int max, int min) {
        this.max = max;
        this.min = min;
    }

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
