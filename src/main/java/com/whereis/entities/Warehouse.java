package com.whereis.entities;

import com.whereis.domain.Containable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity(name = "warehouses")
@RequiredArgsConstructor
public class Warehouse implements Containable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int capacity;

    @ManyToMany(mappedBy = "userWarehouses")
    private List<User> warehouseUsers;
}
