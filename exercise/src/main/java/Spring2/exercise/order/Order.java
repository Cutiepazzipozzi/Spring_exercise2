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
    private OrderProduct product;
}
