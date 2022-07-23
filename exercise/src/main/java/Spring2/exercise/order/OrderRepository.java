package Spring2.exercise.order;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order);
    List<Order> findAll();
    void deleteOrder(Order order);
    int totalPrice(Order order);
}
