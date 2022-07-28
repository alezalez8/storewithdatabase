package shunin.org.entity;

import jdk.jfr.BooleanFlag;
import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Orders")
public class Order {

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


   /* @ManyToMany
    @JoinTable(
            name = "Orders_Products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Products> productsList;*/

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Products> productsList = new ArrayList<>();

    public Order() {
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

   /* public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }*/

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", createDate=" + createDate +
                ", isOrderDone=" + isOrderDone +
                ", client=" + client +
                ", productsList=" + productsList +
                '}';
    }
}
