package shunin.org.service;

import shunin.org.entity.Client;
import shunin.org.entity.Orders;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;

    public ClientService(EntityManager entityManager, EntityTransaction entityTransaction) {
        this.entityManager = entityManager;
        this.entityTransaction = entityTransaction;
    }

    public List<Client> getAllClients() {
        TypedQuery<Client> query = entityManager.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    public void addClient(Client client) {
        entityTransaction.begin();
        try {
            entityManager.persist(client);
            entityTransaction.commit();
        } catch (IllegalStateException e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
        }

    }

    public Client findClientById(Long id) {
        return entityManager.find(Client.class, id);
    }

    public void saveClientWithOrders(Client client, Orders... orders) {
        entityTransaction.begin();
        List<Orders> orderList = new ArrayList<>();
        for (Orders order : orders
        ) {
            order.setClient(client);
            orderList.add(order);
        }
        client.setOrders(orderList);
        try {
            entityManager.persist(client);
            for (Orders order : orders
            ) {
                entityManager.persist(order);
            }

            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
            throw new RuntimeException(ex);
        }
    }


}
