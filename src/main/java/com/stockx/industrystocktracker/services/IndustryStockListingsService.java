package com.stockx.industrystocktracker.services;

import com.stockx.industrystocktracker.IndustryStockListing;
import com.stockx.industrystocktracker.Stock;
import com.stockx.industrystocktracker.Top5StockTickersByMarketCapPerSector;
import com.stockx.industrystocktracker.adapters.LiveStockTrackerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndustryStockListingsService {

    @Autowired
    private LiveStockTrackerAdapter liveStockTrackerAdapter;

    @Autowired
    private Top5StockTickersByMarketCapPerSector top5StockTickersByMarketCapPerSector;

    public IndustryStockListing getIndustryListingsForSector(String sector) throws InvalidKeyException {
        List<String> top5IndustryTickers = top5StockTickersByMarketCapPerSector.getTop5TickersForGivenSector(sector);

        if (top5IndustryTickers == null) {
            throw new InvalidKeyException("The given sector " + sector + " is invalid.");
        }

        IndustryStockListing industryStockListings = new IndustryStockListing(sector, new ArrayList<>());
        for (String stockTicker : top5IndustryTickers) {
            Stock stock = liveStockTrackerAdapter.getStockQuote(stockTicker);
            stock.setTicker(stockTicker);
            industryStockListings.getTop5StocksByMarketCap().add(stock);
        }

        return industryStockListings;
    }

}
