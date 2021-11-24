package com.stockx.industrystocktracker;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Top5StockTickersByMarketCapPerSector {

    private final Map<String, List<String>> top5TickersForEverySector;

    public Top5StockTickersByMarketCapPerSector() {
        this.top5TickersForEverySector = new LinkedHashMap<>();
        initializeSectorsTop5Tickers();
    }


    public List<String> getTop5TickersForGivenSector(String sector) {
        return top5TickersForEverySector.get(sector);
    }

    private void initializeSectorsTop5Tickers() {
        this.top5TickersForEverySector.put("Energy", Arrays.asList("XOM", "CVX", "RDS.A", "COP", "BP"));
        this.top5TickersForEverySector.put("Materials", Arrays.asList("LIN", "BHP", "BBL", "RIO", "DD"));
        this.top5TickersForEverySector.put("Industrials", Arrays.asList("UPS", "UNP", "HON", "RTX", "BA"));
        this.top5TickersForEverySector.put("Utilities", Arrays.asList("NEE", "DUK", "SO", "DUK-PA", "D"));
        this.top5TickersForEverySector.put("Healthcare", Arrays.asList("UNH", "CVS", "ANTM", "SEMHF", "HCA"));
        this.top5TickersForEverySector.put("Financials", Arrays.asList("BRK-B", "BRK-A", "JPM", "BAC", "V"));
        this.top5TickersForEverySector.put("ConsumerDiscretionary", Arrays.asList("AMZN", "TSLA", "HD", "MCD", "LOW"));
        this.top5TickersForEverySector.put("ConsumerStaples", Arrays.asList("WMT", "PG", "KO", "COST", "PEP"));
        this.top5TickersForEverySector.put("InformationTechnology", Arrays.asList("AAPL", "MSFT", "NVDA", "TSM", "ASML"));
        this.top5TickersForEverySector.put("CommunicationServices", Arrays.asList("GOOGL", "GOOG", "FB", "NFLX", "DIS"));
        this.top5TickersForEverySector.put("RealEstate", Arrays.asList("AMT", "PLD", "CCI", "PSA", "SPG"));
    }


}
