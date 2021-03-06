package com.devarchi33.domain;

/**
 * Created by donghoon on 2016. 8. 10..
 */
public enum Country {

    GERMANY("Germany"), USA("USA"), UK("UK"), KOREA("Korea"), SPAIN("Spain");

    private String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
