package org.teamInventory.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.teamInventory.project.model.Product;
import org.teamInventory.project.model.cart;
import org.teamInventory.project.service.productService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class productController {
    @Autowired
    private productService ps;


    @RequestMapping("/")
    public String listProducts(ModelMap model){
        List<Product> products = ps.getAll();
        model.addAttribute("products", products);
        model.addAttribute("productAtt", new Product());
        return "home";

    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productAtt") Product product,BindingResult result) {
            if (result.hasErrors()){
                return "home";
            }
            else {
                System.out.println("name is:>>>>>>>> " + product.getProductName());
                ps.save(product);
                return "redirect:";
            }

    }
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam Long id){

        Product product = ps.getProductById(id);
        ps.delete(product);
        return "redirect:";
    }

    @RequestMapping(value="edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam Long id, ModelMap modelMap){
        Product product = ps.getProductById(id);
        modelMap.put("product", product);
        return "edit";
    }


    @RequestMapping(value="/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product,BindingResult result) {
        if (result.hasErrors()){
            return "edit";
        }
        else {
            System.out.println("name is:>>>>>>>> " + product.getProductName());
            ps.save(product);
            return "redirect:";
        }

    }

    @RequestMapping("/user")
    public String displayProductsUser(ModelMap model){
        List<Product> products = ps.getAll();
        model.addAttribute("products", products);
        return "user";
    }

    @ModelAttribute("cart")
    public cart addtoseesion(){
        return new cart();
    }

    @RequestMapping("/addToCart")
    public String setCart(@ModelAttribute("cart")cart cartAtt, @RequestParam Long id){
        List<Product> cartList = cartAtt.getProducts();
        Product p = ps.getProductById(id);
       for(int i=0; i<cartList.size();i++){
           if(cartList.get(i).getId()==id){
               cartList.get(i).setProductQuantity(cartList.get(i).getProductQuantity()+1);
               return "redirect:/cart";
           }
       }
        p.setProductQuantity(1);
        cartList.add(p);
        cartAtt.setUsername("temp user");
        return "redirect:/cart";
    }

}
