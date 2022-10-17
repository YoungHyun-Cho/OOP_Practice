package app.discount;

public interface DiscountPolicy {
    int discount(DiscountCondition discountCondition, int price);
    DiscountCondition checkDiscount();
}
