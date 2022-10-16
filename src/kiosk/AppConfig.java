package kiosk;

import kiosk.discount.CardDiscountPolicy;
import kiosk.discount.DiscountPolicy;
import kiosk.discount.EventDiscountPolicy;
import kiosk.member.MemberService;
import kiosk.member.MemoryMemberRepository;
import kiosk.order.MemoryOrderRepository;
import kiosk.order.OrderService;
import kiosk.product.MemoryProductRepository;
import kiosk.product.ProductService;

public class AppConfig {
    private String storeName = "Example";
    private String storeAddress = "경기도 수원시 장안구 대평로 27";

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public MemberService memberService() {
        return new MemberService(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderService(
                new MemoryMemberRepository(),
                new MemoryOrderRepository(),
                new DiscountPolicy[] {
                        new CardDiscountPolicy(),
                        new EventDiscountPolicy()
                }
        );
    }

    public ProductService productService() {
        return new ProductService(new MemoryProductRepository());
    }
}
