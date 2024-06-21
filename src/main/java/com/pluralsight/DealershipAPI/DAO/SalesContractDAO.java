package com.pluralsight.DealershipAPI.DAO;


import com.pluralsight.DealershipAPI.model.SalesContract;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class SalesContractDAO {

    public static String jdbcUrl = "jdbc:mysql://localhost:3306/CarDealership";
    public static String jdbcUsername = "yourusername";
    public static String jdbcPassword = "yourpassword";

    public SalesContractDAO() {}

    public SalesContractDAO(String jdbcUrl, String jdbcUsername, String jdbcPassword) {
        this.jdbcUrl = jdbcUrl;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }

    public abstract List<SalesContract> getAllSalesContracts();

    public static void addSalesContract(SalesContract salesContract) {
        String query = "INSERT INTO SalesContracts (VIN, Date, ClientName, CarMake, CarModel) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, salesContract.getVin());
            statement.setString(2, salesContract.getDate());
            statement.setString(3, salesContract.getClientName());
            statement.setString(4, salesContract.getCarMake());
            statement.setString(5, salesContract.getCarModel());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error adding sales contract to database", e);
        }
    }

    public static void updateSalesContract(int id, SalesContract salesContract) {
        String query = "UPDATE SalesContracts SET VIN = ?, Date = ?, ClientName = ?, CarMake = ?, CarModel = ? WHERE SalesContractID = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, salesContract.getVin());
            statement.setString(2, salesContract.getDate());
            statement.setString(3, salesContract.getClientName());
            statement.setString(4, salesContract.getCarMake());
            statement.setString(5, salesContract.getCarModel());
            statement.setInt(6, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error updating sales contract in database", e);
        }
    }

    public static void deleteSalesContract(int id) {
        String query = "DELETE FROM SalesContracts WHERE SalesContractID = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting sales contract from database", e);
        }
    }
}

