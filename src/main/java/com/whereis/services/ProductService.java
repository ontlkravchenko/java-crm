package com.whereis.services;

import com.whereis.entities.Product;
import com.whereis.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public boolean createProduct(Product product) {
        if (product == null) return false;

        productRepo.save(product);
        return true;
    }

    public Product saveChangesToProduct(Product product) {
        if (product == null) return null;

        return productRepo.save(product);
    }

    public Product findById(Long productId, Long whId) {

        return productRepo.findByIdAndWarehouseId(productId, whId);
    }

    public List<Product> findAllByWarehouseId(Long id) {
        return productRepo.findAllByWarehouseId(id);
    }

    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }
}
