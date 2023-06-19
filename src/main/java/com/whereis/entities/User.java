package com.whereis.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

// Lombok
@Data
@RequiredArgsConstructor
// Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 50)
    private String username;

    @Length(max = 255)
    private String eMail;

    private String password;

    private String roles;

//    @JoinTable(
//            name = "warehouse_users",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "warehouse_id")
//    )
    @ManyToMany(mappedBy = "warehouseUsers")
    private List<Warehouse> userWarehouses;

    public void addWarehouse(Warehouse warehouse) {
        if (userWarehouses == null) userWarehouses = new ArrayList<>();

        userWarehouses.add(warehouse);
    }
}
