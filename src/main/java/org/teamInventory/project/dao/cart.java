package org.teamInventory.project.dao;

import java.util.List;

public interface cart {

    List<product> getAllItems();
    void deleteItem(product product);
    void addItemToCart(product product);
}
