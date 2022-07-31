package Spring2.exercise.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.EntityManager;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderSearch {

    private final EntityManager em;

    private String memberName;

    public List<Order> findAll(OrderSearch orderSearch) {
        String jpql = "select o From Order o join o.member m";
        if()
    }
    //이거는 JPA공부 한 후 하는게 좋을듯 싶긴 해용..

}
