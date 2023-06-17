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
        List<Warehouse> warehouses = warehouseService.findAll();

        model.addAttribute("warehouses", warehouses);
        return "home";
    }

}
