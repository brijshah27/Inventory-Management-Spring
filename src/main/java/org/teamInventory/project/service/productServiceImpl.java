package org.teamInventory.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teamInventory.project.dao.productDao;
import org.teamInventory.project.model.Product;

import java.util.List;
@Service
public class productServiceImpl implements productService {
    @Autowired
    private productDao pd;

    @Override
    public List<Product> getAll() {
        return pd.getAll();
    }

    @Override
    public Product getProductById(Long id) {
        return pd.getProductById(id);
    }

    @Override
    public void save(Product product) {
        pd.save(product);
    }

    @Override
    public void delete(Product product) {
        pd.delete(product);
    }
}
