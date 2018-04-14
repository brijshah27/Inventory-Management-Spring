package org.teamInventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.teamInventory.project.model.Product;
import org.teamInventory.project.model.cart;
import org.teamInventory.project.service.productService;

import java.util.Arrays;
import java.util.List;

@Controller
public class cartController {

    @RequestMapping("cart")
    public void displayCart(@SessionAttribute("cart")cart cartAtt, ModelMap model){
        model.addAttribute("cart",cartAtt);
    }

    @RequestMapping("deleteFromCart")
    public String deleteFromCart(@SessionAttribute("cart")cart cartAtt, @RequestParam Long id,ModelMap model){
        for (Product item:cartAtt.getProducts()
             ) {
            if(item.getId()==id){
                cartAtt.getProducts().remove(item);
            }
        }
        return "cart";
    }

}
