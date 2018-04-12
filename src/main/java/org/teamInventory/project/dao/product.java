package org.teamInventory.project.dao;

import java.util.List;

public interface product {

    List<product> getAll();

    product getProductById(Long id);

    void save(product product);

    void  delete(product product);

}
