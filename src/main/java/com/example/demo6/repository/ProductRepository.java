package com.example.demo6.repository;

import com.example.demo6.connecton.MySessionFactory;
import com.example.demo6.model.Product;
import com.example.demo6.request.ProductUpdateResponse;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {

    public void save(Product product){
        Session session = MySessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    public List<Product> findAll() {
        Session session=MySessionFactory.openSession();
        return session.createQuery("select p from Product p",Product.class)
                .getResultList();
    }

    public void update(ProductUpdateResponse productUpdateRespons) {
        Session session=MySessionFactory.openSession();
        Product product1 = session.find(Product.class, productUpdateRespons.getId());
        product1.setCount(productUpdateRespons.getCount());
        product1.setPrice(productUpdateRespons.getPrice());
        product1.setName(productUpdateRespons.getName());
        session.beginTransaction();
        session.update(product1);
        session.getTransaction().commit();
    }

    public void remove(Integer id) {
        Session session = MySessionFactory.openSession();
        Product product = session.find(Product.class, id);
        session.beginTransaction();
        session.remove(product);
        session.getTransaction().commit();
    }
}
