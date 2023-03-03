package cz.antoninvf.beans;

public class StockMarket {
    private int id;
    private String ticker_symbol;
    private String descriptive_name;

    public StockMarket(int id, String ticker_symbol, String descriptive_name) {
        this.id = id;
        this.ticker_symbol = ticker_symbol;
        this.descriptive_name = descriptive_name;
    }

    public int getId() {
        return id;
    }

    public String getTickerSymbol() {
        return ticker_symbol;
    }

    public String getDescriptiveName() {
        return descriptive_name;
    }
}
