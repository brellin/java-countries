package com.countries.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")

public class PopController {

    @GetMapping(value = "/size/{num}", produces = {"application/json"})
    public ResponseEntity<?> getByPopSize(@PathVariable long num){

        ArrayList<Country> filtered = JavaCountriesApplication.countryList
                .find(c -> c.getPopulation() >= num);

        filtered.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(filtered, HttpStatus.OK);

    }

    @GetMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallest(){

        JavaCountriesApplication.countryList.countryList
                .sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        Country smallest = JavaCountriesApplication.countryList.countryList.get(0);

        return new ResponseEntity<>(smallest, HttpStatus.OK);

    }

    @GetMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getLargest(){

        JavaCountriesApplication.countryList.countryList
                .sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        Country largest = JavaCountriesApplication.countryList.countryList.get(0);

        return new ResponseEntity<>(largest, HttpStatus.OK);

    }

}
