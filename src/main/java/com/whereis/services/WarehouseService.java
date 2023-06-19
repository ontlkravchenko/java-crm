package com.whereis.services;

import com.whereis.entities.User;
import com.whereis.entities.Warehouse;
import com.whereis.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseService {

    /*
    Created in order to make it more convenient to work with warehouseRepo
     */

    @Autowired
    private UserService userService;

    @Autowired
    private WarehouseRepo warehouseRepo;

    public List<Warehouse> findAllForCurrentUser() {
//        return warehouseRepo.findAll();
        User user = userService.getAuthorizedUser();
        return user.getUserWarehouses();
    }

    public Warehouse save(Warehouse warehouse) {
        // Assign default warehouses to the current user
        User user = userService.getAuthorizedUser();
        List<Warehouse> defaultWarehouses = new ArrayList<>();
        user.setUserWarehouses(defaultWarehouses);

        // Save the warehouse
        Warehouse savedWarehouse = warehouseRepo.save(warehouse);

        // Update the user's warehouses
        userService.saveUser(user);

        return savedWarehouse;
    }
}
