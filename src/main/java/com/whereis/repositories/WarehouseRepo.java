package com.whereis.repositories;

import com.whereis.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {
}
