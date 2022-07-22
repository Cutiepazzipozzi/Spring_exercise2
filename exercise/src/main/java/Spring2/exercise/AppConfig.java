package Spring2.exercise;

import Spring2.exercise.member.MemberRepositoryImpl;
import Spring2.exercise.member.MemberRepository;
import Spring2.exercise.member.MemberService;
import Spring2.exercise.order.OrderRepository;
import Spring2.exercise.order.OrderRepositoryImpl;
import Spring2.exercise.product.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }

    @Bean
    public OrderRepository orderRepository() {
        return new OrderRepositoryImpl();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }


}
