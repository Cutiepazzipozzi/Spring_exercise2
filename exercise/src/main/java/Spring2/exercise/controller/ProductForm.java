package Spring2.exercise.controller;

import Spring2.exercise.product.OrderProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private String ProductName;
    private int ProductPrice;
    private int ProductNumber;
    private OrderProduct kind;
}
