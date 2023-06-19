package com.whereis.controllers;

import com.whereis.entities.User;
import com.whereis.entities.Warehouse;
import com.whereis.services.UserService;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class WHCreateController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    UserService userService;

    @GetMapping("wh-create")
    public String showPage(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "wh-create";
    }

    @PostMapping("wh-create")
    public String processForm(@ModelAttribute Warehouse warehouse) {

        // Get current user from DB
        User user = userService.getAuthorizedUser();

        // Add current user to warehouse's users
        user.addWarehouse(warehouse);

        warehouseService.saveWarehouse(warehouse);
        userService.saveUser(user);
        return "redirect:/";
    }
}
