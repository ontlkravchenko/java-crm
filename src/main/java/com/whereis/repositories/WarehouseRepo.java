package com.whereis.repositories;

import com.whereis.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse, Long> {

    List<Warehouse> findAllByUsersUsername(String username);
}
