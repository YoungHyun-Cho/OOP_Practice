package kiosk.order;

public interface OrderRepository {
    Order[] getOrders();
    int addOrder(Order order);
}
