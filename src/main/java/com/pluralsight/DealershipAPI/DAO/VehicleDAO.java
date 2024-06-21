package com.pluralsight.DealershipAPI.DAO;

import com.pluralsight.DealershipAPI.model.Vehicle;

import java.util.List;

public interface VehicleDAO {

    Vehicle getVehicleByDealershipID();

    Vehicle getVehicleByName();

    Vehicle getVehicleVIN();

    List<Vehicle> getAllVehicles();

    List<Vehicle> getDealershipID(int getDealershipID);

    List<Vehicle> getVehicleByDealershipID(int id);

    String addVehicle(Vehicle vehicle);

    String updateVehicle(int id, Vehicle vehicle);

    boolean deleteVehicle(int id);

}
