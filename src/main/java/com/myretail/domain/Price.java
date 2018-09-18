package com.myretail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Price {

    @JsonProperty
    @NotNull
    private String value;

    @JsonProperty("currency_code")
    @NotNull
    private String currencyCode;


    public Price(String value, String currencyCode) {
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
