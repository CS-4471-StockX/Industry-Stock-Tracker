package com.stockx.industrystocktracker.controllers;

import com.stockx.industrystocktracker.IndustryStockListing;
import com.stockx.industrystocktracker.services.IndustryStockListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidKeyException;

@RestController
public class IndustryStockListingsController {

    @Autowired
    private IndustryStockListingsService industryStockListingsService;

    @CrossOrigin(origins = "*")
    @GetMapping("/industry-stock-listings")
    public IndustryStockListing getStockByTicker(@RequestParam("sector") String sector) {

        try {
            return industryStockListingsService.getIndustryListingsForSector(sector);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
