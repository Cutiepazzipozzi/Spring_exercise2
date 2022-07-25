package Spring2.exercise.controller;

import Spring2.exercise.order.Order;
import Spring2.exercise.order.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OrderController {
    OrderRepository orderRepository;
    @GetMapping("/orders/join")
    public String join() {
        return "orders/joinOrder";
    }

    @PostMapping("/orders/join")
    public String enroll(OrderForm form) {
        Order order = new Order(form.getMember(), form.getProduct(), form.getPNumber());
        order.setMember(form.getMember());
        order.setProduct(form.getProduct());
        order.setPNumber(form.getPNumber());

        orderRepository.createOrder(order);
        return "redirect:/";
    }

    @GetMapping("/orders/list")
    public String list(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "orders/orderList";
    }
}
