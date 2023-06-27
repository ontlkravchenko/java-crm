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

    @GetMapping("/warehouse-{whId}/product-{productId}")
    public String showProductPage(
            @PathVariable Long whId,
            @PathVariable Long productId,
            Model model
    ) {
        Product product = productService.findById(productId);

        model.addAttribute("product", product);

        return "product/page-product";
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

        return "product/create-product";
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

    //  Edit
    @GetMapping("/edit-product-{productId}")
    public String showEditProductPage(
            @PathVariable Long productId,
            Model model
    ) {
        Product product = productService.findById(productId);
        if (product == null) return "redirect:/";

        model.addAttribute("product", product);

        return "product/edit-product";
    }

    @PostMapping("/edit-product")
    public String processEditProductForm(@ModelAttribute Product product) {
        Warehouse wh = productService.getWarehouseFromId(product.getId());
        final Long WH_ID = wh.getId();
        product.setWarehouse(wh);

        productService.saveChangesToProduct(product);
        return "redirect:/warehouse-" + WH_ID + "/product-" + product.getId();
    }

    //  Delete
    @GetMapping("delete-product-{productId}")
    public String showDeleteProductPage(@PathVariable Long productId, Model model) {
        Product p = productService.findById(productId);
        if (p == null) return "redirect:/";

        model.addAttribute("product", p);
        return "product/delete-product";
    }

    @PostMapping("delete-product-{productId}")
    public String processDeleteProductForm(@PathVariable Long productId) {
        Warehouse wh = productService.getWarehouseFromId(productId);
        productService.deleteById(productId);

        return "redirect:/";
    }
}
