package com.example.covid20;

public class CountryModel {
    private String flag,country,cases,todayDeaths,todayCases,deaths,recovered,critical,active,tests,population;

    public CountryModel() {

    }

    public CountryModel(String flag, String country, String cases, String todayDeaths, String todayCases, String deaths, String recovered, String critical, String active, String tests, String population) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.todayDeaths = todayDeaths;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.recovered = recovered;
        this.critical = critical;
        this.active = active;
        this.tests = tests;
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
