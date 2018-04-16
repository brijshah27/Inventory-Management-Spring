package org.teamInventory.project.dao;

import org.teamInventory.project.model.Cart;
import org.teamInventory.project.model.Product;

import java.util.List;

public interface cartDao {

    List<Product> getAllItems();
    void deleteItem(Product product);
    void addItemToCart(Product product);
    void addAllItemsToCart(List<Product> allProducts);
    void saveToCart(Cart cart);
}
