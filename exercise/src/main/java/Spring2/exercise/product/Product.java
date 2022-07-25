package Spring2.exercise.product;

import Spring2.exercise.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="product")
@Getter
@Setter
public class Product {

    @Id @GeneratedValue
    @Column(name="product_id")
    private Long id;
    private String ProductName;
    private int ProductPrice;
    private int ProductNumber;
    @Enumerated(EnumType.STRING)
    private OrderProduct kind;

    public Product(String productName, int ProductPrice, int ProductNumber, OrderProduct kind) {
        this.ProductName = productName;
        this.ProductPrice = ProductPrice;
        this.ProductNumber = ProductNumber;
        this.kind = kind;
    }
}
