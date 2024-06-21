package com.pluralsight.DealershipAPI.cli;

import com.pluralsight.DealershipAPI.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DealershipApplication implements CommandLineRunner {

    private final VehicleService vehicleService;

    @Autowired
    public DealershipApplication(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(vehicleService.getAllVehicles());
    }

}
