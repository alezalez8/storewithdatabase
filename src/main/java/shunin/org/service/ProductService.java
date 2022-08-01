package shunin.org.service;

import shunin.org.entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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
        List<Products> productsList = null;
        try {
            TypedQuery<Products> query = entityManager.createQuery("SELECT p FROM Products p", Products.class);
            productsList = query.getResultList();
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
        }
        return productsList;
    }

    public void addProduct(Products product) {
        entityTransaction.begin();
        try {
            entityManager.persist(product);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
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
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
        }

    }

    public void deleteProduct(Long id) {
        entityTransaction.begin();
        try {
            Products product = entityManager.getReference(Products.class, id);
            entityManager.remove(product);
            entityManager.flush();
            entityTransaction.commit();

        } catch (IllegalStateException | EntityNotFoundException e) {
            System.out.println("This DB not contain product with id = " + id);
        }
    }
}
