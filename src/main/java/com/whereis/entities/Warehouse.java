package com.whereis.entities;

import com.whereis.domain.Containable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Warehouse implements Containable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int capacity;
}
