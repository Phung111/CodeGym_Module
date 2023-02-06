package com.example.customermanager.service;

import com.example.customermanager.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAllCountry();
    Country findCountryById(long id);

    boolean insertCountryBySP(String nameCountry);


    boolean testProcedure();
}
