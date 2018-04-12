package org.teamInventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.teamInventory.project.dao.productDao;
import org.teamInventory.project.model.Product;
import org.teamInventory.project.service.cartService;
import org.teamInventory.project.service.productService;

import java.util.List;

@Controller
public class productController {
    @Autowired
    private productService ps;


    @GetMapping("/")
    public String listProducts(Model model){
        List<Product> products = ps.getAll();
        model.addAttribute("products", products);
        return "templetes/home";

    }
}
