package cz.antoninvf.beans;

import java.util.Date;

public class Trade {
    private int id;
    private int amount;
    private int price;
    private int stock_market_id;
    private Date created_at;

    public Trade(int id, int amount, int price, int stock_market_id, Date created_at) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.stock_market_id = stock_market_id;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public int getStock_market_id() {
        return stock_market_id;
    }

    public Date getCreated_at() {
        return created_at;
    }
}
