package com.assignment.country_api.service;

import com.assignment.country_api.entity.Country;
import com.assignment.country_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Long id, Country updatedCountry) {
        Country existing = getCountryById(id);
        existing.setName(updatedCountry.getName());
        existing.setCapital(updatedCountry.getCapital());
        return countryRepository.save(existing);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
