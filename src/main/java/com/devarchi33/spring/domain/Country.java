package com.devarchi33.spring.domain;

/**
 * Created by donghoon on 2016. 8. 10..
 */
public enum Country {

    GERMANY("Germany"), USA("Usa"), UK("Uk"), KOREA("Korea");

    private String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
