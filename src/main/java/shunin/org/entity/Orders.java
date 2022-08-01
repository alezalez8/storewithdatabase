package shunin.org.entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "create_date")
    @Timestamp
    private Date createDate = new Date();

    @Column(name = "order_done", nullable = false, columnDefinition = "BOOLEAN")
    private boolean isOrderDone = true;


    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;


    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "Orders_Products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Products> productsList = new ArrayList<>();


    public Orders() {
    }


    public Orders(Client client, List<Products> productsList) {
        this.client = client;
        this.productsList = productsList;
    }


    public void setProductToOrder(Products... product) {
        for (int i = 0; i < product.length; i++) {
            productsList.add(product[i]);
        }
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isOrderDone() {
        return isOrderDone;
    }

    public void setOrderDone(boolean orderDone) {
        isOrderDone = orderDone;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "createDate=" + createDate +
                ", isOrderDone=" + isOrderDone +
                ", client=" + client +
                '}';
    }
}
