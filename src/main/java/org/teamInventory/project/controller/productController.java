package org.teamInventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teamInventory.project.model.Product;
import org.teamInventory.project.service.productService;

import java.util.List;

@Controller
public class productController {
    @Autowired
    private productService ps;


    @RequestMapping("/")
    public String listProducts(Model model){
        List<Product> products = ps.getAll();
        model.addAttribute("products", products);
        System.out.print("hehrehrhe"+products.get(0).getProductname());
        return "home";

    }
}
