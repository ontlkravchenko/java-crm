package com.whereis.controllers;

import com.whereis.entities.Warehouse;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public String home(Model model) {
        List<Warehouse> warehouses = new ArrayList<>();
        Warehouse wh = new Warehouse();
        wh.setName("first");
        wh.setCapacity(50);
        warehouses.add(wh);
        wh = new Warehouse();
        wh.setName("second");
        wh.setCapacity(2);
        warehouses.add(wh);

        model.addAttribute("warehouses", warehouses);
        return "home";
    }

}
