package com.pluralsight.DealershipAPI.service;
import com.pluralsight.DealershipAPI.DAO.VehicleDAO;
import com.pluralsight.DealershipAPI.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.sql.*;

@Component
public class VehicleService {

    private VehicleDAO vehicleDAO = null;

    @Autowired
    public VehicleService(VehicleDAO VehicleDAOImpl) {
        this.vehicleDAO = vehicleDAO;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDAO.getAllVehicles();
    }

    public List<Vehicle> getDealershipID(int id) {
        return vehicleDAO.getDealershipID(id);
    }

    public String addVehicle(Vehicle vehicle) {
        return vehicleDAO.addVehicle(vehicle);
    }

    public String updateVehicle(int id, Vehicle vehicle) {
        return vehicleDAO.updateVehicle(id, vehicle);
    }

    public boolean deleteVehicle(int id) {
        return vehicleDAO.deleteVehicle(id);
    }


    public static Vehicle generateVehicle(ResultSet rs) throws SQLException {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setDealershipID(rs.getInt("DealershipID"));
        newVehicle.setVIN(rs.getInt("VIN"));
        newVehicle.setVehicleMake(rs.getString("VehicleMake"));
        newVehicle.setVehicleModel(rs.getString("VehicleModel"));
            return newVehicle;
    }

}