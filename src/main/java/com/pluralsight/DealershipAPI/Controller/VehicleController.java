package com.pluralsight.DealershipAPI.Controller;

import com.pluralsight.DealershipAPI.model.Vehicle;
import com.pluralsight.DealershipAPI.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    public String index(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name;
    }

    public List<Vehicle> vehicles() {
        return vehicleService.getAllVehicles();
    }

    public List<Vehicle> vehicle(@PathVariable int id) {
        return vehicleService.getVehicleByVIN(id);
    }

    public String addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    public String updateVehicle(@PathVariable int DealershipID, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(DealershipID, vehicle);
    }

    public boolean deleteVehicle(@PathVariable int dealershipID) {
        return vehicleService.deleteVehicle(dealershipID);
    }

}
