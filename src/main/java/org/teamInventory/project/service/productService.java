package org.teamInventory.project.service;

import org.teamInventory.project.model.Product;

import java.util.List;

public interface productService {

    List<Product> getAll();

    Product getProductById(Long id);

    void save(Product product);

    void  delete(Product product);
}
