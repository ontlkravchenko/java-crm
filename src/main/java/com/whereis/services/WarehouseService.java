package com.whereis.services;

import com.whereis.entities.Warehouse;
import com.whereis.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService {

    /*
    Created in order to make it more convenient to work with warehouseRepo
     */

    @Autowired
    UserService userService;

    @Autowired
    WarehouseRepo warehouseRepo;

    public Warehouse saveWarehouse(Warehouse warehouse) {
        Warehouse WHWithCurrentUser = userService.addWarehouseToCurrentUser(warehouse);
        return warehouseRepo.save(WHWithCurrentUser);
    }

    public Warehouse findById(Long id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepo.findById(id);

        return optionalWarehouse.orElse(null);
    }
}
