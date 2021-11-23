package com.stockx.industrystocktracker.services;

import com.stockx.industrystocktracker.IndustryStockListing;
import com.stockx.industrystocktracker.Stock;
import com.stockx.industrystocktracker.adapters.LiveStockTrackerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndustryStockListingsService {

    @Autowired
    private LiveStockTrackerAdapter liveStockTrackerAdapter;

    public IndustryStockListing getIndustryListingsForSector(String sector) {

        // TODO Figure out how to do this
        List<String> top10StockTickersByVolume;

        IndustryStockListing industryStockListings = new IndustryStockListing(sector, new ArrayList<>());
        industryStockListings.setSector(sector);

        for (String stockTicker : top10StockTickersByVolume) {
            industryStockListings.getTop10StocksByVolume().add(liveStockTrackerAdapter.getStockQuote(stockTicker));
        }

        return industryStockListings;
    }

}
