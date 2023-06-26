package com.whereis.services;

import com.whereis.entities.Product;
import com.whereis.entities.Warehouse;
import com.whereis.repositories.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    ProductService productService;

    public Warehouse createWarehouse(Warehouse warehouse) {
        Warehouse WHWithCurrentUser = userService.addWarehouseToCurrentUser(warehouse);
        return warehouseRepo.save(WHWithCurrentUser);
    }

    public boolean saveChangesInWarehouse(Warehouse warehouse) {
        return warehouseRepo.save(warehouse) != null;
    }

    public Warehouse findById(Long id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepo.findById(id);

        return optionalWarehouse.orElse(null);
    }

    public List<Product> getProductsById(Long whId) {
        return productService.findAllByWarehouseId(whId);
    }
}
