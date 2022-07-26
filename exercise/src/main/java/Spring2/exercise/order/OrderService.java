package Spring2.exercise.order;

import Spring2.exercise.member.Member;
import Spring2.exercise.member.MemberRepository;
import Spring2.exercise.product.Product;
import Spring2.exercise.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        return
    }




}
