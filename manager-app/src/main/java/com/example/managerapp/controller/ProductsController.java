package com.example.managerapp.controller;

import com.example.managerapp.controller.payload.NewProductPayload;
import com.example.managerapp.entity.Product;
import com.example.managerapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping("list")
    public String getProductsList(Model model) {
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @GetMapping("create")
    public String getNewProductsPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProductPayload payload) {

        Product product = this.productService.createProduct(payload.title(), payload.details());
        return "redirect:/catalogue/products/list/%d".formatted(product.getId());
    }

    @GetMapping("{product:\\d+}")
    public String getProduct(@PathVariable("product") int productId, Model model) {
        model.addAttribute("product", this.productService.findProduct(productId).orElseThrow());
        return "catalogue/products/product";
    }
}
