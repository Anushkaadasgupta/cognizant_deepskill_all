package com.cognizant.jwt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.jwt.model.Country;

@Repository
public class CountryDao {

    private static List<Country> countryList = new ArrayList<>();

    static {
        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("DE", "Germany"));
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("JP", "Japan"));
    }

    public List<Country> getAllCountries() {
        return countryList;
    }
}