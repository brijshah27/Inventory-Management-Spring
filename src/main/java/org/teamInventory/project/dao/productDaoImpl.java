package org.teamInventory.project.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class productDaoImpl implements product {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<product> getAll() {
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<product> criteria = builder.createQuery(product.class);

        // Specify criteria root
        criteria.from(product.class);

        // Execute query
        List<product> products = session.createQuery(criteria).getResultList();

        // Close session
        session.close();

        return products;
    }

    @Override
    public product getProductById(Long id) {
        Session session = sessionFactory.openSession();
        product product = session.get(product.class,id);
        session.close();
        return product;
    }

    @Override
    public void save(product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        session.close();
    }
}
