package com.countries.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class JavaCountriesApplication {

    public final static CountryList countryList = new CountryList();

    public static void main(String[] args) {
        SpringApplication.run(JavaCountriesApplication.class, args);
    }

}
