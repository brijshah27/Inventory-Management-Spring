package org.teamInventory.project.dao;

import org.teamInventory.project.model.Product;

import java.util.List;

public interface productDao {

    List<Product> getAll();

    Product getProductById(Long id);

    void save(Product product);

    void  delete(Product product);

}
