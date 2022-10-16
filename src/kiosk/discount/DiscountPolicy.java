package kiosk.discount;

public interface DiscountPolicy {
    int discount(DiscountCondition discountCondition, int price);
}
