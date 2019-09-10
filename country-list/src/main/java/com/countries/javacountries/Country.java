package com.countries.javacountries;

public class Country {

    private String name;
    private long population;
    private long landMassSize;
    private int medAge;


    public Country(String name, long population, long landMassSize, int medAge) {
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medAge = medAge;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(int population){
        this.population = population;
    }

    public long getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(int landMassSize) {
        this.landMassSize = landMassSize;
    }

    public int getMedAge() {
        return medAge;
    }

    public void setMedAge(byte medAge) {
        this.medAge = medAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
