package com.stockx.industrystocktracker.configurations;

import com.stockx.industrystocktracker.Top5StockTickersByMarketCapPerSector;
import com.stockx.industrystocktracker.adapters.LiveStockTrackerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Value("${live-stock-tracker-url}")
    private String liveStockTrackerUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public LiveStockTrackerAdapter liveStockTrackerAdapter(RestTemplate restTemplate) {
        return new LiveStockTrackerAdapter(restTemplate, liveStockTrackerUrl);
    }

    @Bean
    public Top5StockTickersByMarketCapPerSector top5StockTickersByMarketCapPerSector() {
        return new Top5StockTickersByMarketCapPerSector();
    }

}
