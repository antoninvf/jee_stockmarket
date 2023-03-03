package cz.antoninvf.services;

import cz.antoninvf.beans.StockMarket;
import cz.antoninvf.beans.StockMarketsBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;

@Named
@ApplicationScoped
public class StockmarketService {
    private StockMarketsBean stockMarketsBean = new StockMarketsBean();
    private ArrayList<StockMarket> stockMarkets = stockMarketsBean.getStockMarkets();

}
