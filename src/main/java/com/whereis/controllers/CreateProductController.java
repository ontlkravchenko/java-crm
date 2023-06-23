package com.whereis.controllers;

import com.whereis.entities.Product;
import com.whereis.entities.Warehouse;
import com.whereis.services.ProductService;
import com.whereis.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateProductController {

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    ProductService productService;

    @GetMapping("warehouse-{whId}/create-product")
    public String showPage(
            @PathVariable Long whId,
            Model model
            ) {
        Warehouse wh = warehouseService.findById(whId);
        if (wh == null) return "redirect:/";

        model.addAttribute("product", new Product());
        model.addAttribute("whId", whId);

        return "create-product";
    }

    @PostMapping("warehouse-{whId}/create-product")
    public String processForm(
            @PathVariable Long whId,
            @ModelAttribute Product product
    ) {
        Warehouse wh = warehouseService.findById(whId);
        if (wh == null) return "redirect:/";

        productService.createProduct(product);

        return "redirect:warehouse-" + whId + "/products";
    }
}
