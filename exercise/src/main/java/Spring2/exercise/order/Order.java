package Spring2.exercise.order;

import Spring2.exercise.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy="order")
    private List<>
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
