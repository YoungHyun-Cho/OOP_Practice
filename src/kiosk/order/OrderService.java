package kiosk.order;

import kiosk.Basket;
import kiosk.discount.DiscountCondition;
import kiosk.discount.DiscountPolicy;
import kiosk.member.Member;
import kiosk.member.MemberRepository;

public class OrderService {
    private MemberRepository memberRepository;
    private OrderRepository orderRepository;
    private DiscountPolicy[] discountPolicies;

    public OrderService(MemberRepository memberRepository, OrderRepository orderRepository, DiscountPolicy[] discountPolicies) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.discountPolicies = discountPolicies;
    }

    public Order createOrder(int memberId, Basket basket, DiscountCondition[] discountConditions) {
        int finalPrice = basket.calculateTotalPrice();
        for (int i = 0; i < discountPolicies.length; i++) {
            finalPrice = discountPolicies[i].discount(discountConditions[i], finalPrice);
        }

        int lastIndex = orderRepository.getOrders().length;
        return new Order(lastIndex, memberId, basket.getProducts(), finalPrice);
    }
}
