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
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
// Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Length(max = 50)
    private final String username;

    @Length(max = 255)
    private final String eMail;

    private final String password;

    private final String roles;

    @ManyToMany
    private final List<Warehouse> warehouses;
}
