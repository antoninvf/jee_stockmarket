package cz.antoninvf.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;

@Named
@RequestScoped
public class OrdersBean {
    public ArrayList<Order> getOrders() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM stock_market.order")
        ) {
            ArrayList<Order> orders = new ArrayList<>();

            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt("order_id"),
                        resultSet.getInt("order_direction_id"),
                        resultSet.getInt("amount"),
                        resultSet.getInt("price"),
                        resultSet.getInt("stock_market_id"),
                        resultSet.getDate("created_at")
                ));
            }

            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
