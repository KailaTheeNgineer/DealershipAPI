package com.pluralsight.DealershipAPI.model;

import java.sql.*;

public class SalesContract {

    private boolean salesContractScreen = true;

    public SalesContract(boolean salesContractScreen) {
        this.salesContractScreen = salesContractScreen;
    }

    public void setSalesContractScreen(boolean salesContractScreen) {
        this.salesContractScreen = salesContractScreen;
    }

    public String allSalesContracts(String username, String password) {
        try {
            System.out.println("Vehicles Inventory: \n");
            String InventoryQuery = "SELECT * FROM SalesContracts";


            Connection connection;
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarDealership", username, password);
            PreparedStatement statement = connection.prepareStatement(InventoryQuery);


            ResultSet results = statement.executeQuery();

            while (results.next()) {
                return "Contract ID: " +
                        results.getString("SalesContractID") +
                        " VIN: " + results.getString("VIN") + " Date: "
                        + results.getString("Date") + " Name: "
                        + results.getString("ClientName")
                        + " Make: " + results.getString("CarMake")
                        + " Model: " + results.getString("CarModel")+ "\n";

            }

            results.close();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "No Contracts Found";
    }




}
