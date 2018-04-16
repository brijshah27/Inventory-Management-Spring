package org.teamInventory.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamInventory.project.dao.cartDao;
import org.teamInventory.project.model.Cart;
import org.teamInventory.project.model.Product;

import java.util.List;
@Service
public class cartServiceImpl implements cartService {
    @Autowired
    private cartDao cd;

    @Override
    public List<Product> getAllItems() {
        return cd.getAllItems();
    }

    @Override
    public void deleteItem(Product product) {
        cd.deleteItem(product);
    }

    @Override
    public void addItemToCart(Product product) {
        cd.addItemToCart(product);
    }
    @Override
    public void addAllItemsToCart(List<Product> allProducts) {
        cd.addAllItemsToCart(allProducts);
    }

    @Override
    public void saveToCart(Cart cart) {
        cd.saveToCart(cart);
    }
}