package com.whereis.controllers;

import com.whereis.entities.Warehouse;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditWarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("edit-wh-{id}")
    public String showPage(@PathVariable(name = "id") Long id, Model model) {
        Warehouse userWh = warehouseService.findById(id);
        if (userWh == null) return "redirect:/";

        model.addAttribute("warehouse", userWh);

        return "edit-wh";
    }

    @PostMapping("edit-wh")
    public String processForm(@ModelAttribute Warehouse warehouse) {
        if (warehouse.getId() == null) return "redirect:/";

        warehouseService.saveChangesInWarehouse(warehouse);

        return "redirect:/warehouse-" + warehouse.getId();
    }
}
