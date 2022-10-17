package app;

import app.discount.CardDiscountPolicy;
import app.discount.DiscountPolicy;
import app.discount.EventDiscountPolicy;
import app.member.MemberRepository;
import app.member.MemberService;
import app.member.MemoryMemberRepository;
import app.order.MemoryOrderRepository;
import app.order.OrderRepository;
import app.order.OrderService;
import app.product.MemoryProductRepository;
import app.product.ProductRepository;
import app.product.ProductService;

public class AppConfig {
    private String storeName = "🍔 Burger Queen";

    public String getStoreName() {
        return storeName;
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderRepository orderRepository() {
        return new MemoryOrderRepository();
    }

    public ProductRepository productRepository() {
        return new MemoryProductRepository();
    }

    public DiscountPolicy[] discountPolicies() {
        return new DiscountPolicy[] {
                new CardDiscountPolicy(),
                new EventDiscountPolicy()
        };
    }

    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    public ProductService productService() {
        return new ProductService(productRepository());
    }

    public OrderService orderService() {
        return new OrderService(
                memberRepository(),
                orderRepository(),
                discountPolicies()
        );
    }

}
