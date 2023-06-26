package com.whereis.controllers;

import com.whereis.entities.Product;
import com.whereis.entities.Warehouse;
import com.whereis.services.UserService;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String showAllWarehousesPage(Model model) {
        List<Warehouse> warehouses = userService.getAuthorizedUser().getWarehouses();

        model.addAttribute("warehouses", warehouses);
        return "home";
    }

    @GetMapping("warehouse-{id}")
    public String showWarehousePage(@PathVariable Long id, Model model) {
        Warehouse warehouse = warehouseService.findById(id);
        if (warehouse == null) return "redirect:/";

        model.addAttribute("warehouse", warehouse);
        return "page-warehouse";
    }

    @GetMapping("warehouse-{whId}/products")
    public String showPageWarehouseProducts(@PathVariable Long whId, Model model) {
        List<Product> products = warehouseService.getProductsById(whId);

        model.addAttribute("products", products);
        model.addAttribute("whId", whId);

        return "page-warehouseProducts";
    }

    /*
    CRUD
     */

    //  Create
    @GetMapping("wh-create")
    public String showPageWHCreate(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "create-wh";
    }

    @PostMapping("wh-create")
    public String processFormFromWHCreate(@ModelAttribute Warehouse warehouse) {

        warehouseService.createWarehouse(warehouse);

        return "redirect:/";
    }

    //  Edit
    @GetMapping("edit-wh-{id}")
    public String showPageEditWH(@PathVariable(name = "id") Long id, Model model) {
        Warehouse userWh = warehouseService.findById(id);
        if (userWh == null) return "redirect:/";

        model.addAttribute("warehouse", userWh);

        return "edit-wh";
    }

    @PostMapping("edit-wh")
    public String processFormEditWH(@ModelAttribute Warehouse warehouse) {
        if (warehouse.getId() == null) return "redirect:/";

        warehouseService.saveChangesInWarehouse(warehouse);

        return "redirect:/warehouse-" + warehouse.getId();
    }

    //  Delete


}
