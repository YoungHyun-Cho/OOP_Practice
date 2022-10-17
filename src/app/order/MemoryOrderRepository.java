package app.order;

public class MemoryOrderRepository implements OrderRepository {

    private Order[] orders = new Order[0];

    @Override
    public Order addOrder(Order order) {
        Order[] newOrders = new Order[orders.length + 1];
        System.arraycopy(orders, 0, newOrders, 0, orders.length);
        newOrders[newOrders.length - 1] = order;
        orders = newOrders;
        return order;
    }

    @Override
    public Order[] findAll() {
        return orders;
    }
}
