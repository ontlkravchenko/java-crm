package com.whereis.controllers;

import com.whereis.entities.Product;
import com.whereis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class WarehouseProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("warehouse-{whId}/products")
    public String showPage(@PathVariable Long whId, Model model) {
        List<Product> products = productService.findAllByWarehouseId(whId);

        model.addAttribute("products", products);
        model.addAttribute("whId", whId);

        return "page-warehouseProducts";
    }
}
