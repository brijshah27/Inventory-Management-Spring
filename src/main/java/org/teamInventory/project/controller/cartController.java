package org.teamInventory.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.teamInventory.project.model.Product;
import org.teamInventory.project.model.cart;

@Controller
public class cartController {
    @RequestMapping("cart")
    public void displayCart(@SessionAttribute("cart")cart cartAtt, ModelMap model){
        String name = cartAtt.getProducts().get(0).getProductName();
        model.addAttribute("cart",cartAtt);
        System.out.println("inside display cart>>>"+name);
    }

}
