package Spring2.exercise.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderSearch {

    private final EntityManager em;

    private String memberName;

    public List<Order> findAll(OrderSearch orderSearch) {
        String jpql = "select o From Order o join o.member m";
        boolean first = true;

        //회원이름
        if(StringUtils.hasText(orderSearch.getMemberName())) {
            if(first) {
                jpql += " where";
                first = false;
            }
            else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000);

        if(StringUtils.hasText(orderSearch.getMemberName())) {
            query = query.setParameter("name", orderSearch.getMemberName());
        }

        return query.getResultList();
    }
    //이거는 JPA공부 한 후 하는게 좋을듯 싶긴 해용..

}
