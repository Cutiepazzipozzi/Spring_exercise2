package Spring2.exercise.controller;

import Spring2.exercise.member.Member;
import Spring2.exercise.member.MemberService;
import Spring2.exercise.order.Order;
import Spring2.exercise.order.OrderSearch;
import Spring2.exercise.order.OrderService;
import Spring2.exercise.product.Product;
import Spring2.exercise.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;
    private final MemberService memberService;

    //대부분 서비스의 형태를 띄는 것이 좋음

    @GetMapping("/orders/join")
    public String join(Model model) {
        List<Member> members = memberService.findAll();
        List<Product> products = productService.findAll();

        model.addAttribute("members", members);
        model.addAttribute("products", products);

        return "orders/joinOrder";
    }

    @PostMapping("/orders/join")
    public String enroll(@RequestParam("memberId") Long memberId,
                @RequestParam("productId") Long productId,
                         @RequestParam("count") int count) {
        orderService.order(memberId, productId, count);
        return "redirect:/";
  }


    //보엣 주문 조회가 안될 듯함...
    //이거 말고
    @PostMapping("/orders/list/{orderId}")
    public String delete(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/";
    }

    @GetMapping("/orders/list")
    public String orderList(@ModelAttribute("orderSearch")OrderSearch orderSearch, Model model) {
        List<Order> orders = orderSearch.findAll(orderSearch);
        model.addAttribute("orders", orders);

        return "orders/orderList";
    }

}
