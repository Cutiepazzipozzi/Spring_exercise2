package Spring2.exercise.order;

import Spring2.exercise.member.Member;
import Spring2.exercise.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private String pName;
    private int pNumber;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(Member member, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        for(OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        return order;
    }

    public void cancel() {
        for(OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
        //원래는 배달 중이면 취소할 수 없다는 경고를 띄워야 하나 나는 배달 상태를 제외시킴
    }

    public int getTotalPrice() {
        int total=0;
        for(OrderItem orderItem : orderItems) {
            total += orderItem.getTotalPrice();
        }
        return total;
    }

}
