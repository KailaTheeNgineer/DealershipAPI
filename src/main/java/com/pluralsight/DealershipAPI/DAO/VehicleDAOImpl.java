package com.pluralsight.DealershipAPI.DAO;

import com.pluralsight.DealershipAPI.model.Vehicle;
import com.pluralsight.DealershipAPI.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDAOImpl implements VehicleDAO {

    private DataSource dataSource;

    @Autowired
    public VehicleDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Vehicle getVehicleByName() {
        return null;
    }

    @Override
    public Vehicle getVehicleVIN() {
        return null;
    }

    @Override
    public Vehicle getVehicleByDealershipID() {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> products = new ArrayList<>();

        String sql = "SELECT * FROM Inventory;";
        try(Connection connection = dataSource.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(sql);
            while(rows.next()){
                products.add(VehicleService.generateVehicle(rows));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return products;
    }

    @Override
    public List<Vehicle> getDealershipID(int getDealershipID) {
        return List.of();
    }

    @Override
    public List<Vehicle> getVehicleByDealershipID(int id) {
        List<Vehicle> product = new ArrayList<>();

        String sql = "SELECT * FROM Products WHERE ProductID = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                product.add(VehicleService.generateVehicle(rows));
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return product;
    }

    @Override
    public String addVehicle(Vehicle vehicle) {
        String res = "";

        String sql = "INSERT INTO Inventory (`DealershipID`, `VIN`, `VehicleMake`, `VehicleModel`) VALUES(?,?,?,?);";

        try(Connection connection = dataSource.getConnection();){
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, vehicle.getDealershipID());
            statement.setInt(2, vehicle.getVIN());
            statement.setString(3, vehicle.getVehicleMake());
            statement.setString(4, vehicle.getVehicleModel());
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                // Iterate through the primary keys that were generated
                while (keys.next()) {
                    res = keys.getString(1);
                }
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return res;
    }

    @Override
    public String updateVehicle(int id, Vehicle vehicle) {
        String res = "";

            String sql = "UPDATE Inventory SET DealershipID = ?, VIN = ?, VehicleMake = ?, VehicleModel = ?, WHERE DealershipID = ?";

        try(Connection connection = dataSource.getConnection();){
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, vehicle.getDealershipID());
            statement.setInt(2, vehicle.getDealershipID());
            statement.setString(3, vehicle.getVehicleMake());
            statement.setString(4, vehicle.getVehicleModel());
            res = String.valueOf(statement.executeUpdate());
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return res;
    }

    @Override
    public boolean deleteVehicle(int id) {
        String sql = "DELETE FROM Inventory WHERE DealershipID = ?";

        try(Connection connection = dataSource.getConnection();){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

}
