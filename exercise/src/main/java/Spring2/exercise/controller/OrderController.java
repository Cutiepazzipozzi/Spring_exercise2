package Spring2.exercise.controller;

import Spring2.exercise.order.Order;
import Spring2.exercise.order.OrderRepository;
import Spring2.exercise.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/join")
    public String join() {
        return "orders/joinOrder";
    }

    @PostMapping("/orders/join")
    public String enroll(OrderForm form) {
        Order order = new Order();
        order.setMember(form.getMember());
        order.setPName(form.getPName());
        order.setPNumber(form.getPNumber());

        orderService.order(form.getMember().getId(), );
        return "redirect:/";
    }

    @GetMapping("/orders/list")
    public String list(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "orders/orderList";
    }
}
