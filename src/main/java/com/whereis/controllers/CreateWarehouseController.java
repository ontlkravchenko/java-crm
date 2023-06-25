package com.whereis.controllers;

import com.whereis.entities.Warehouse;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateWarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("wh-create")
    public String showPage(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "create-wh";
    }

    @PostMapping("wh-create")
    public String processForm(@ModelAttribute Warehouse warehouse) {

        warehouseService.createWarehouse(warehouse);

        return "redirect:/";
    }
}