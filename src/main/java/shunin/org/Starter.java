package shunin.org;


import shunin.org.entity.Client;
import shunin.org.entity.Orders;
import shunin.org.entity.Products;
import shunin.org.service.ClientService;
import shunin.org.service.FillDataBaseService;
import shunin.org.service.OrderService;
import shunin.org.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Starter {


    public static void main(String[] args) {
        String NAME = "JPAofProducts";
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(NAME);
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();


      //  ClientService clientService = new ClientService(entityManager, entityTransaction); // 9
      //  OrderService orderService = new OrderService(entityManager, entityTransaction); // 8
      //  ProductService productService = new ProductService(entityManager, entityTransaction); // 7

        // fill database
       // new FillDataBaseService(entityManager, entityTransaction).initDB();


        // 5
       /* System.out.println("=================All clients ================================");
        List<Client> clientList = clientService.getAllClients();
        printToConsole(clientList);
        System.out.println("\n");
        System.out.println("=================All products================================");
        List<Products> productsList = productService.getAllProducts();
        printToConsole(productsList);
        System.out.println("\n");*/
        // 4
        /*System.out.println("=================Find product with id=10 =====================");
        System.out.println(productService.findProductById(10L));
        System.out.println("\n");
        System.out.println("=================Update product with id=10 ===================");
        productService.updateAndSave(8, 100, "SmartTV", 10L);
        System.out.println(productService.findProductById(10L));
        System.out.println("\n");*/
        // 1
       /* System.out.println("=================Delete product with id=8  ===================");
        productService.deleteProduct(8L);*/

       /* // 6
        System.out.println("\n");
        System.out.println("=================All products ================================");
        printToConsole(productService.getAllProducts());
        System.out.println("\n");
        System.out.println("=================Get all order ===============================");
        List<Orders> orderList = orderService.getAllOrders();
        printToConsole(orderList);
        System.out.println("\n");*/


        // 2
        /*System.out.println("=================Create new order =============================");
        System.out.println("For client with id=2  assign to him products with id=4 and id=7");
        orderService.makeOrder(2L, 4L, 7L);*/
        System.out.println("\n");
        System.out.println("=================Get all order ===============================");

        // 6 - 1
       /* orderList = orderService.getAllOrders();
        printToConsole(orderList);
        System.out.println("\n");*/

        // 3
       /* System.out.println("=================New client with new order  ====================");
        Client newClient = new Client("Aleks", "Ivanov");
        Products productOne = productService.findProductById(3L);
        Products productTwo = productService.findProductById(5L);
        Orders newOrder = new Orders(newClient, new ArrayList<>(Arrays.asList(productOne, productTwo)));
        clientService.saveClientWithOrders(newClient, newOrder);
        System.out.println("\n");

        System.out.println("=================Get products for client with id = 10  ==========");
        orderService.getProductsByClientId(10L);*/


        // Close all

        managerFactory.close();
        //entityManager.close();
        //managerFactory.close();


    }

    public static <T> void printToConsole(List<T> list) {
        if (list != null) {
            for (T t : list
            ) {
                System.out.println(t);
            }
        }
    }


}
