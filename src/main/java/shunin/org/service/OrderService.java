package shunin.org.service;

import shunin.org.entity.Client;
import shunin.org.entity.Orders;
import shunin.org.entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;


    public OrderService(EntityManager entityManager, EntityTransaction entityTransaction) {
        this.entityManager = entityManager;
        this.entityTransaction = entityTransaction;

    }

    public List<Orders> getAllOrders() {
        List<Orders> orderList;
        TypedQuery<Orders> query = entityManager.createQuery("SELECT o FROM Orders o", Orders.class);
        orderList = query.getResultList();
        return orderList;
    }

    public Orders findOrderById(Long id) {
        Orders order;
        order = entityManager.getReference(Orders.class, id);
        if (order == null) {
            System.out.println("Can't find order with id = " + id);
        }
        return order;
    }

    public void deleteOrder(Long id) {
        entityTransaction.begin();
        try {
            Orders order = entityManager.getReference(Orders.class, id);
            entityManager.remove(order);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            System.out.println("Can't delete this order");
        }

    }

    public void makeOrder(Long clientId, Long... idProducts) {
        List<Products> productsList = new ArrayList<>();
        Client client = entityManager.find(Client.class, clientId);
        for (int i = 0; i < idProducts.length; i++) {
            productsList.add(entityManager.find(Products.class, idProducts[i]));
        }
        Orders currentOrder = new Orders(client, productsList);
        entityTransaction.begin();
        try {
            entityManager.persist(currentOrder);
            entityTransaction.commit();

        } catch (Exception ex) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            throw new RuntimeException(ex);
        }

    }

    public void getProductsByClientId(Long clientId) {
        List<Products> productsList;
        Client client = entityManager.getReference(Client.class, clientId);
        System.out.println("== You choose client: " + client.getName() + " " + client.getSurename() + " ==");
        List<Orders> orderList = client.getOrders();
        for (Orders order: orderList
             ) {
            System.out.println("For ORDER # " + order.getOrderId());
            productsList = order.getProductsList();
            for (Products product: productsList
                 ) {
                System.out.println("Title: " + product.getTitle() + ", cost is " + product.getPrice());
            }
        }
    }


}
