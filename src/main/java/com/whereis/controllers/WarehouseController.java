package com.whereis.controllers;

import com.whereis.entities.Warehouse;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("warehouse-{id}")
    public String showPage(@PathVariable Long id, Model model) {

        Warehouse warehouse = warehouseService.findById(id);

        model.addAttribute("warehouse", warehouse);
        return "warehousePage";
    }
}
