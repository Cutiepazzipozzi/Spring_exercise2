package Spring2.exercise.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.EntityManager;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderSearch {

    private final EntityManager em;

    private String memberName;

    //이거는 JPA공부 한 후 하는게 좋을듯 싶긴 해용..

}
