package com.whereis.entities;

import com.whereis.domain.Storeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity(name = "products")
public class Product implements Storeable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @Length(max = 50)
    private String name;

    private String description;

    @Min(0)
    private float weightKG;
}
