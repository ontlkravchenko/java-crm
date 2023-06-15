package com.whereis.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

// Lombok
@Data
@RequiredArgsConstructor
// Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Length(max = 50)
    private String username;

    @Length(max = 255)
    private String eMail;

    private String password;

    private String roles;

    @ManyToMany
    private List<Warehouse> warehouses;
}
