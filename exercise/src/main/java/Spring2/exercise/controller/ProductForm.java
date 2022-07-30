package Spring2.exercise.controller;

import Spring2.exercise.product.OrderProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private Long id;
    private String ProductName;
    private int ProductPrice;
    private int stockQuantity;
    private OrderProduct kind;
}
