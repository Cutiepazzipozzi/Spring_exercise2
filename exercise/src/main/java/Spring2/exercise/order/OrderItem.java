package Spring2.exercise.order;

import Spring2.exercise.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Entity
@Table(name="order_item")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name="order_item_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    //이게 얘를 달아주지 않으면 바로 등록돼 문제가 발생하나보오
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    private int OrderPrice;
    private int count; //주문 수량

    //주문 생성,.
    public static OrderItem createOrderItem(Product product, int OrderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setOrderPrice(OrderPrice);
        orderItem.setCount(count);

        product.removeStock(count);
        return orderItem;
    }

    //비즈니스
    public void cancel() {
        getProduct().addStock(count);
    }
    public int getTotalPrice() {
        return getOrderPrice()*getCount();
    }
}
