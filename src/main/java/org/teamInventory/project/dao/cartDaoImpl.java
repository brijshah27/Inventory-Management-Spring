package org.teamInventory.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class cartDaoImpl implements cart {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<product> getAllItems() {
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<product> criteria = builder.createQuery(product.class);

        // Specify criteria root
        criteria.from(cart.class);

        // Execute query
        List<product> products = session.createQuery(criteria).getResultList();

        // Close session
        session.close();

        return products;
    }

    @Override
    public void deleteItem(product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addItemToCart(product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
    }
}
