package cz.antoninvf.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;

@Named
@RequestScoped
public class StockMarketsBean {
    public ArrayList<StockMarket> getStockMarkets() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM stock_market")
        ) {
            ArrayList<StockMarket> stockMarkets = new ArrayList<>();

            while (resultSet.next()) {
                stockMarkets.add(new StockMarket(
                        resultSet.getInt("stock_market_id"),
                        resultSet.getString("ticker_symbol"),
                        resultSet.getString("descriptive_name")
                ));
            }

            return stockMarkets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addStockMarket(StockMarket stockMarket) {
        if (stockMarket.getTickerSymbol() == null || stockMarket.getDescriptiveName() == null) return;
        if (getStockMarkets().contains(stockMarket)) return;

        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO stock_market (ticker_symbol, descriptive_name) VALUES (?, ?)")
        ) {
            statement.setString(1, stockMarket.getTickerSymbol());
            statement.setString(2, stockMarket.getDescriptiveName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStockMarket(int id) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement statement = connection.prepareStatement("DELETE FROM stock_market WHERE stock_market_id = ?")
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStockMarket(StockMarket stockMarket) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement statement = connection.prepareStatement("UPDATE stock_market SET ticker_symbol = ?, descriptive_name = ? WHERE stock_market_id = ?")
        ) {
            statement.setString(1, stockMarket.getTickerSymbol());
            statement.setString(2, stockMarket.getDescriptiveName());
            statement.setInt(3, stockMarket.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public StockMarket getStockMarket(int id) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3309/stock_market?user=root&password=heslo");
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM stock_market WHERE stock_market_id = ?")
        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new StockMarket(
                    resultSet.getInt("stock_market_id"),
                    resultSet.getString("ticker_symbol"),
                    resultSet.getString("descriptive_name")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
