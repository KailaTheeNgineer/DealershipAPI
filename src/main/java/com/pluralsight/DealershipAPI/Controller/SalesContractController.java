package com.pluralsight.DealershipAPI.Controller;


import com.pluralsight.DealershipAPI.DAO.SalesContractDAO;
import com.pluralsight.DealershipAPI.model.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class SalesContractController {

    @Autowired
    private SalesContractDAO salesContractDAO;

    @GetMapping
    public List<SalesContract> getAllSalesContracts() {
        return salesContractDAO.getAllSalesContracts();
    }

    @PostMapping
    public void SalesContract(@RequestBody SalesContract salesContract) {
        salesContractDAO.addSalesContract(salesContract);
    }

    @PutMapping("/{id}")
    public void updateSalesContract(@PathVariable int id, @RequestBody SalesContract salesContract) {
        salesContractDAO.updateSalesContract(id, salesContract);
    }

    @DeleteMapping("/{id}")
    public void deleteSalesContract(@PathVariable int id) {
        salesContractDAO.deleteSalesContract(id);

    }
}