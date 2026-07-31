package com.cognizant.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.jwt.dao.CountryDao;
import com.cognizant.jwt.model.Country;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }
}