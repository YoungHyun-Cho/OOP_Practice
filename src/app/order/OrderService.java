package app.order;

import app.discount.DiscountCondition;
import app.discount.DiscountPolicy;
import app.member.MemberRepository;
import app.product.Product;

public class OrderService {
    private MemberRepository memberRepository;
    private OrderRepository orderRepository;
    private DiscountPolicy[] discountPolicies;

    public OrderService(MemberRepository memberRepository, OrderRepository orderRepository, DiscountPolicy[] discountPolicies) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.discountPolicies = discountPolicies;
    }

    public Order createOrder(int memberId, Product[] products, DiscountCondition[] discountConditions) {

        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        for (int i = 0; i < discountPolicies.length; i++) {
            totalPrice = discountPolicies[i].discount(discountConditions[i], totalPrice);
        }

        int newOrderId = orderRepository.findAll().length;

        return orderRepository.addOrder(new Order(newOrderId, memberId, products, totalPrice));
    }
}
