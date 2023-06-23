package com.whereis.controllers;

import com.whereis.entities.Product;
import com.whereis.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("warehouse-{whId}/product-{productId}")
    public String showPage(
            @PathVariable Long whId,
            @PathVariable Long productId,
            Model model
    ) {
        Product product = productService.findById(productId, whId);
        if (product == null) return "redirect:/";

        model.addAttribute("product", product);

        return "page-product";
    }
}
