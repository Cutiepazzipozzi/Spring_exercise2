package Spring2.exercise.order;

import Spring2.exercise.member.Member;
import Spring2.exercise.member.MemberRepository;
import Spring2.exercise.product.Product;
import Spring2.exercise.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Long order(Long memberId, Long productId, int count) {
        Member member = memberRepository.findOne(memberId);
        Product product = productRepository.findOne(productId);

        OrderItem orderItem
                = OrderItem.createOrderItem(product, product.getProductPrice(),  count);

        Order order = Order.createOrder(member, orderItem);
        orderRepository.join(order);

        return order.getId();
    }

    public void cancelOrder(Long id) {
        Order order = orderRepository.findOne(id);
        order.cancel();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    //이제 ordersearch가 들어감 물품이나 회원명으로 사람을 찾는?
    public void orderSearch() {

    }
}
