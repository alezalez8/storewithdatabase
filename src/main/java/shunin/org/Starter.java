package shunin.org;


import shunin.org.entity.Client;
import shunin.org.entity.Order;
import shunin.org.entity.Products;
import shunin.org.service.ClientService;
import shunin.org.service.OrderService;
import shunin.org.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Starter {


    public static void main(String[] args) {
        String NAME = "JPAofProducts";
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(NAME);
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
        } catch (IllegalStateException e) {
            managerFactory.close();
            entityManager.close();
        }


        ClientService clientService = new ClientService(entityManager, entityTransaction);
        OrderService orderService = new OrderService(entityManager, entityTransaction);
        ProductService productService = new ProductService(entityManager, entityTransaction);

       /* System.out.println("=================All products================================");
        List<Products> productsList = productService.getAllProducts();
        printToConsole(productsList);
        System.out.println("=================Find product with id=10 =====================");
        System.out.println(productService.findProductById(10L));
        System.out.println("=================Update product with id=10 ===================");
        productService.updateAndSave(8, 100, "something", 10L);
        System.out.println(productService.findProductById(10L));
        System.out.println("=================Delete product with id=8  ===================");
        productService.deleteProduct(8L);
        printToConsole(productService.getAllProducts());*/
        System.out.println("\n\n");
        System.out.println("=================All clients ================================");

       Client client = clientService.findClientById(1L);
       List<Order> orderList = client.getOrders();
       printToConsole(orderList);
        System.out.println("----------------------------------------------------");
        for (Order order: orderList
             ) {
            order.getProductsList().forEach(System.out::println);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }


        //  List<Order> orderList = orderService.getAllOrder();
      //  printToConsole(orderList);
       // orderService.deleteOrder(32L);
       // orderList = orderService.getAllOrder();
       // printToConsole(orderList);

       /* List<Client> clientList = clientService.getAllClients();
        printToConsole(clientList);
        System.out.println("==============================");

        List<Order> orderList = orderService.getAllOrder();
        printToConsole(orderList);
        System.out.println("==============================");
        System.out.println(clientService.findClientById(5L));
        System.out.println("==============================");
        Client client = new Client("Test", "One");
        clientService.addClient(client);
        System.out.println("==============================");

        Client client1 = new Client("Aleks", "Ivanov");
        Order order1 = new Order();
        Order order2 = new Order();

        clientService.saveClientWithOrders(client1, order1, order2);*/

    }

    public static <T> void printToConsole(List<T> list) {
        for (T t : list
        ) {
            System.out.println(t);
        }
    }
}
