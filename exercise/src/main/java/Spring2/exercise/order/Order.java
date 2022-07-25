package Spring2.exercise.order;

import Spring2.exercise.member.Member;
import Spring2.exercise.product.Product;
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
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Product product;

    private int pNumber;

    public Order(Member member, Product product, int pNumber) {
        this.member = member;
        this.product = product;
        this.pNumber = pNumber;
    }
}
