package Spring2.exercise.member;

import Spring2.exercise.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    private String name;

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @Column(name="member_city")
    private String city;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
 }
