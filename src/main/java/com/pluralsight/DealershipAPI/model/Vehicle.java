package com.pluralsight.DealershipAPI.model;

public class Vehicle {
    private int dealershipID;
    private int VIN;
    private String vehicleMake;
    private String vehicleModel;

    public Vehicle() {

    }


    public int getDealershipID() {
        return dealershipID;
    }

    public int getVIN() {
        return VIN;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setDealershipID(int dealershipID) {
        this.dealershipID = dealershipID;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public String toString() {
        return
                "Dealership ID: " + dealershipID +
                        ", VIN: " + VIN +
                        ", Make: " + vehicleMake +
                        ", Model: " + vehicleModel;
    }
}
