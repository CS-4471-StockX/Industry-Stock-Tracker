package com.stockx.industrystocktracker.controllers;

import com.stockx.industrystocktracker.IndustryStockListing;
import com.stockx.industrystocktracker.services.IndustryStockListingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndustryStockListingsController {

    @Autowired
    private IndustryStockListingsService industryStockListingsService;

    @GetMapping("/industry-stock-listings")
    public IndustryStockListing getStockByTicker(@RequestParam("sector") String sector) {
        return industryStockListingsService.getIndustryListingsForSector(sector);
    }

}
