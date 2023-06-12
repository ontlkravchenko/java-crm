package com.whereis;

import com.whereis.entities.Warehouse;
import com.whereis.repositories.WarehouseRepo;
import com.whereis.services.WarehouseService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhereisApplication {

    public static void main(String[] args) {

        SpringApplication.run(WhereisApplication.class, args);
    }

}
