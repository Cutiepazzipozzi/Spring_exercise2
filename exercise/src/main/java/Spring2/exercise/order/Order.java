package Spring2.exercise.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Order {
    private String pName;
    private int price;
    private int pNumber;

    public Order(String pName, int price, int pNumber) {
        this.pName = pName;
        this.price = price;
        this.pNumber = pNumber;
    }
}
