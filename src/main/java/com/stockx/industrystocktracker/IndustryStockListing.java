package com.stockx.industrystocktracker;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IndustryStockListing {

    private String sector;
    private List<Stock> top10StocksByVolume;

}
