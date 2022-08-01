package shunin.org.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;


    @Column(name = "amount")
    @Min(value = 1)
    private int amount;

    @ManyToMany(mappedBy = "productsList", cascade = {CascadeType.ALL})
    private List<Orders> orderList = new ArrayList<>();

    public Products() {
    }

    public Products(String title, double price, int count) {
        this.title = title;
        this.price = price;
        this.amount = count;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int count) {
        this.amount = count;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Product: [" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", count=" + amount +
                ']';
    }
}
