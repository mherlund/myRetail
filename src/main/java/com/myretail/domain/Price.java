package com.myretail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Price {

    @JsonProperty
    @NotNull
    private double value;

    @JsonProperty("currency_code")
    @NotNull
    private String currencyCode;


    public Price(Double value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public Price(Price price){
        this(price.getValue(), price.getCurrencyCode());
    }

    public Price(ProductPrice productPrice) {
        this(productPrice.getCurrentPrice());
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
