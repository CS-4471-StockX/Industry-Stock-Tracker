package com.stockx.industrystocktracker.adapters;

import com.stockx.industrystocktracker.Stock;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
public class LiveStockTrackerAdapter {

    RestTemplate restTemplate;
    String baseURL;

    public Stock getStockQuote(String ticker) {
        String url = UriComponentsBuilder.fromUriString(baseURL).path("/stock-quote")
                .queryParam("ticker", ticker).build().toString();
        return restTemplate.getForObject(url, Stock.class);
    }


}
