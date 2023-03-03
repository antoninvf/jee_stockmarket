package cz.antoninvf.beans;

import java.util.Date;

public class Order {
    private int id;
    private int order_direction_id;
    private int amount;
    private int price;
    private int stock_market_id;
    private Date created_at;

    public Order(int id, int order_direction_id, int amount, int price, int stock_market_id, Date created_at) {
        this.id = id;
        this.order_direction_id = order_direction_id;
        this.amount = amount;
        this.price = price;
        this.stock_market_id = stock_market_id;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public int getOrder_direction_id() {
        return order_direction_id;
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
