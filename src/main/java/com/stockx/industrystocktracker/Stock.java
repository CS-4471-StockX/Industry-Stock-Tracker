package com.stockx.industrystocktracker;


import lombok.Data;

@Data
public class Stock {

    private String ticker;

    private Double currentPrice;

    private Double priceChange;

    private Double percentageChange;

    private Double dayHigh;

    private Double dayLow;

    private Double openingPrice;

    private Double previousClosingPrice;

}