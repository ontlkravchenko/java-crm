package com.whereis.entities;

import com.whereis.domain.Containable;
import jakarta.persistence.*;
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

    @ManyToMany(mappedBy = "warehouses")
    private List<User> users;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
