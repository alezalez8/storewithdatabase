package shunin.org.service;

import shunin.org.entity.Client;
import shunin.org.entity.Order;
import shunin.org.entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class OrderService {
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;


    public OrderService(EntityManager entityManager, EntityTransaction entityTransaction) {
        this.entityManager = entityManager;
        this.entityTransaction = entityTransaction;
    }

    public List<Order> getAllOrder() {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        List<Order> orderList = query.getResultList();
        return orderList;
    }

    public Order findOrderById(Long id) {
        Optional<Order> order = Optional.of(Optional.of(entityManager.find(Order.class, id)).orElse(null));
        return order.get();
    }

    public void deleteOrder(Long id) {
        Order order = findOrderById(id);
        if (order != null) {
            try {
                entityTransaction.begin();
                //  Long idClient = order.getClient().getClientId();
                // List<Products> productsList = order.getProductsList();
                entityManager.remove(entityManager.getReference(Order.class, id));
                entityTransaction.commit();
            } catch (IllegalStateException e) {
                System.out.println("wtrwetwtq[iooiuiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
            }

        }

    }


}
