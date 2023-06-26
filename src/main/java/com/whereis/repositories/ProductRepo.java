package com.whereis.repositories;

import com.whereis.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {

    public Product findByIdAndWarehouseId(Long id, Long whId);
    public List<Product> findAllByWarehouseId(Long id);
}
