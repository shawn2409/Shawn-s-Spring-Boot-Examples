package com.example.demo.impl;

import com.example.demo.model.Country;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
@RestController
public class CountryController {

    public static final String REST_SERVICE_Countries_URI = "http://localhost:8080/countries";


    public static final String REST_SERVICE_Rates_URI = "https://bitpay.com/api/rates";


    @RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Country> getCountries() {
        RestTemplate restTemplate= new RestTemplate();
        Country country= new Country();

        ResponseEntity<List<Country>> rateResponse =
                restTemplate.exchange(REST_SERVICE_Countries_URI,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {
                        });
        List<Country> countryClientList = rateResponse.getBody();

       for(Country c:countryClientList){
         if(c.getCountryName().equals("India")){
             c.setCountryName("Bangladesh");

             List<Country> cc= new ArrayList<>();

             cc.add(c);

             return cc;

         }
       }


        return countryClientList;
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountry() {
        RestTemplate restTemplate= new RestTemplate();
        Country country= new Country();

        ResponseEntity<List<Country>> rateResponse =
                restTemplate.exchange(REST_SERVICE_Countries_URI,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {
                        });
        List<Country> countryClientList = rateResponse.getBody();

        for(Country c:countryClientList){
            if(c.getCountryName().equals("India")){
                c.setCountryName("Bangladesh");
                return c;
            }
        }


        return null;
    }
}

