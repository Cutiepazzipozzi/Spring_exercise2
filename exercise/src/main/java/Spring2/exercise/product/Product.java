package Spring2.exercise.product;

import Spring2.exercise.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Product {
    private String ProductName;
    private int ProductPrice;
    private int ProductNumber;
    private OrderProduct kind;

    public Product(String productName, int ProductPrice, int ProductNumber, OrderProduct kind) {
        this.ProductName = productName;
        this.ProductPrice = ProductPrice;
        this.ProductNumber = ProductNumber;
        this.kind = kind;
    }
}
