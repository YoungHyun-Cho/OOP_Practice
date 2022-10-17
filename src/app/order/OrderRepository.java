package app.order;

public interface OrderRepository {
    Order[] findAll();
    Order addOrder(Order order);
}
