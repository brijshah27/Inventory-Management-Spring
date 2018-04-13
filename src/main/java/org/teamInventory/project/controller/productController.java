package org.teamInventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.teamInventory.project.model.Product;
import org.teamInventory.project.service.productService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class productController {
    @Autowired
    private productService ps;


    @RequestMapping("/")
    public String listProducts(ModelMap model){
        List<Product> products = ps.getAll();
        model.addAttribute("products", products);
        System.out.print(">>>>>>>>"+products.get(0).getProductname());
        return "home";

    }

    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productAtt") Product product, BindingResult result) {
            if (result.hasErrors()){
                return "home";
            }
            else {
                System.out.println("name is:>>>>>>>> " + product.getProductname());
                ps.save(product);
                return "home";
            }

    }

}
