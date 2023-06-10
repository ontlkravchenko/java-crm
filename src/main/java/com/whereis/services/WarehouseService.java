package com.whereis.services;

import com.whereis.entities.Warehouse;
import com.whereis.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepo warehouseRepo;

    public List<Warehouse> findAll() {
        return warehouseRepo.findAll();
    }

    public Warehouse save(Warehouse warehouse) {
        return warehouseRepo.save(warehouse);
    }
}
