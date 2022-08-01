package shunin.org.service;

import shunin.org.entity.Client;
import shunin.org.entity.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class FillDataBaseService {
    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;

    public FillDataBaseService(EntityManager entityManager, EntityTransaction entityTransaction) {
        this.entityManager = entityManager;
        this.entityTransaction = entityTransaction;
    }


    public void initDB() {
        Client client1 = new Client("Aleksandr", "Shunin");
        Client client2 = new Client("Aleksey", "Pupkin");
        Client client3 = new Client("Leonid", "Ivanov");
        Client client4 = new Client("Petr", "Petrov");
        Client client5 = new Client("Grigoriy", "Sidorov");
        Client client6 = new Client("Boris", "Jenkenson");
        Client client7 = new Client("Tom", "Cruis");
        Client client8 = new Client("Igor", "Perepelkin");
        Client client9 = new Client("Vlad", "Severov");


        Products product1 = new Products("Iphone", 14300, 10);
        Products product2 = new Products("Ipad", 12150, 9);
        Products product3 = new Products("Toy", 485, 200);
        Products product4 = new Products("Clock", 5450, 35);
        Products product5 = new Products("Notebook", 23500, 5);
        Products product6 = new Products("Netbook", 14550, 6);
        Products product7 = new Products("Printer", 5880, 15);
        Products product8 = new Products("Tools", 1200, 24);
        Products product9 = new Products("Soft", 5000, 30);
        Products product10 = new Products("Monitor", 8850, 14);

        entityTransaction.begin();
        try {
            /*for (int i = 1; i < 10; i++) {
                String currentClient = "client" + i;
                String currentProduct = "product" + i;
                entityManager.persist(currentClient);
                entityManager.persist(currentProduct);*/

            String currentClient = "client" + 1;

            entityManager.persist(client1);
            entityManager.persist(client2);
            entityManager.persist(client3);
            entityManager.persist(client4);
            entityManager.persist(client5);
            entityManager.persist(client6);
            entityManager.persist(client7);
            entityManager.persist(client8);
            entityManager.persist(client9);

            entityManager.persist(product1);
            entityManager.persist(product2);
            entityManager.persist(product3);
            entityManager.persist(product4);
            entityManager.persist(product5);
            entityManager.persist(product6);
            entityManager.persist(product7);
            entityManager.persist(product8);
            entityManager.persist(product9);
            entityManager.persist(product10);

            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction.isActive())
                entityTransaction.rollback();
        }
    }

}
