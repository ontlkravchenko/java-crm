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
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    WarehouseService warehouseService;

    @GetMapping("warehouse-{whId}/product-{productId}")
    public String showProductPage(
            @PathVariable Long whId,
            @PathVariable Long productId,
            Model model
    ) {
        Product product = productService.findById(productId, whId);
//        if (product == null) return "redirect:/";

        model.addAttribute("product", product);

        return "page-product";
    }

    /*
    CRUD
     */

    //  Create
    @GetMapping("warehouse-{whId}/create-product")
    public String showCreateProductPage(
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
    public String processCreateProductForm(
            @PathVariable Long whId,
            @ModelAttribute Product product
    ) {
        Warehouse wh = warehouseService.findById(whId);
        if (wh == null) return "redirect:/";

        product.setWarehouse(wh);
        productService.createProduct(product);

        return "redirect:products";
    }
}
