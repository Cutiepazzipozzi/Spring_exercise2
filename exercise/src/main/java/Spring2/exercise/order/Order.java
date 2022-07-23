package Spring2.exercise.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Order {

    private Member member;
    private String pName;
    private int pNumber;
    private String address;

    public Order(Member member, String pName, int pNumber, String address) {
        this.member = member;
        this.pName = pName;
        this.pNumber = pNumber;
        this.address = address;
    }
}
