package org.teamInventory.project.service;

import org.teamInventory.project.model.Product;

import java.util.List;

public interface cartService
{

    List<Product> getAllItems();
    void deleteItem(Product product);
    void addItemToCart(Product product);
}