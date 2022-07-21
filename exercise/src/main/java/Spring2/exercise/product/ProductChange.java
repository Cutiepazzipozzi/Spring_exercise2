package Spring2.exercise.product;

public class ProductChange {

    private String ProductName;
    private int ProductPrice;
    private int ProductNumber;
    private OrderProduct kind;

    public Product change(Product product) {
        return new Product(ProductName, ProductPrice, ProductNumber, kind);
    }
}
