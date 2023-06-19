package com.whereis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WarehouseController {
    @GetMapping("warehouse-{id}")
    public String showPage(@PathVariable Integer id, Model model) {
        model.addAttribute("id", id);
        return "warehousePage";
    }
}
