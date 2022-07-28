package shunin.org.service;

import org.hibernate.hql.internal.ast.tree.Statement;
import shunin.org.entity.Client;
import shunin.org.entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductService {
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;

    public ProductService(EntityManager entityManager, EntityTransaction entityTransaction) {
        this.entityManager = entityManager;
        this.entityTransaction = entityTransaction;
    }

    public List<Products> getAllProducts() {
        TypedQuery<Products> query = entityManager.createQuery("SELECT p FROM Products p", Products.class);
        List<Products> productsList = query.getResultList();
        return productsList;
    }

    public void addProduct(Products product) {
        entityTransaction.begin();
        try {
            entityManager.persist(product);
            entityTransaction.commit();
        } catch (IllegalStateException e) {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public Products findProductById(Long id) {
        return entityManager.find(Products.class, id);
    }

    public void updateAndSave(int amount, double price, String title, Long id) {
        //  TypedQuery<Products> query = entityManager.createQuery("SELECT p FROM Products p WHERE id=:id", Products.class);
        entityTransaction.begin();
        try {
            Products product = entityManager.find(Products.class, id);
            product.setAmount(amount);
            product.setPrice(price);
            product.setTitle(title);
            entityManager.persist(product);
            entityTransaction.commit();
        } catch (IllegalStateException e) {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }

    }

    public void deleteProduct(Long id) {
        try {
            entityTransaction.begin();
            Products product = entityManager.getReference(Products.class, id);
            entityManager.remove(product);
            entityManager.flush();
            entityTransaction.commit();

        } catch (Exception e) {
            entityManager.close();
            System.out.println("This DB not contain product with id = " + id);
        }
    }
}
