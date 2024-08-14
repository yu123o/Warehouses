package com.example.warehouses.Service;

import com.example.warehouses.Model.Warehouse;
import com.example.warehouses.Model.WarehouseResponse;
import com.example.warehouses.Repository.WarehouseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Transactional
    public List<Warehouse> getWarehouses(Integer wId, Integer wCreatedBy, String wName) {
        try {
        return warehouseRepository.returnWarehouses(wId, wCreatedBy, wName);
        } catch (Exception e) {
            // Log the exception (optional)
            System.out.println("An error occurred during login: " + e.getMessage());
            return null; // or handle the exception as needed
        }
    }

    public WarehouseResponse InsertWarehouse(String wName,String wDescription, Integer wCreatedBy) {
        try {
            Integer generatedId =  warehouseRepository.insertWarehouse(wName, wDescription, wCreatedBy);
            return new WarehouseResponse(generatedId);

        } catch (Exception e) {
            System.out.println("An error occurred during login: " + e.getMessage());
            return null; // or handle the exception as needed
        }
    }

    public Integer deleteWarehouses(String warehouseIds) {
        return warehouseRepository.deleteWarehouses(warehouseIds);
    }
}
