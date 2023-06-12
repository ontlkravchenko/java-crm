package com.whereis.controllers;

import com.whereis.entities.Warehouse;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping
    public String home(Model model) {
        Warehouse w = new Warehouse();
        w.setName("ITWORKS???");
        w.setCapacity(50);
        warehouseService.save(w);
        // This is to test if DB works
        List<Warehouse> warehouses = warehouseService.findAll();
        model.addAttribute("warehouses", warehouses);
        return "home";
    }
}
