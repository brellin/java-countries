package com.countries.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/name")

public class NameController {

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllCountries(){
        JavaCountriesApplication.countryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(JavaCountriesApplication.countryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "start/{letter}")
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter){

        ArrayList<Country> countries = JavaCountriesApplication.countryList
                .find(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));

        countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(countries, HttpStatus.OK);

    }

    @GetMapping(value = "/size/{num}")
    public ResponseEntity<?> getCountriesFilteredBySize(@PathVariable int num){

        ArrayList<Country> countries = JavaCountriesApplication.countryList
                .find(c -> c.getName().length() >= num);

        countries.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(countries, HttpStatus.OK);

    }

}
