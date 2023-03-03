package cz.antoninvf.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;

@Named
@RequestScoped
public class TradesBean {
    public ArrayList<Trade> getTrades() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM trade")
        ) {
            ArrayList<Trade> trades = new ArrayList<>();

            while (resultSet.next()) {
                trades.add(new Trade(
                        resultSet.getInt("trade_id"),
                        resultSet.getInt("amount"),
                        resultSet.getInt("price"),
                        resultSet.getInt("stock_market_id"),
                        resultSet.getDate("created_at")
                ));
            }

            return trades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
