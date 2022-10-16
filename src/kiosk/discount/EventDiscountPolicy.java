package kiosk.discount;

public class EventDiscountPolicy implements DiscountPolicy {

    int discountRate = 10;

    @Override
    public int discount(DiscountCondition discountCondition, int price) {
        if (discountCondition == DiscountCondition.CODESTATES_STUDENT) return calculateDiscountedPrice(price, discountRate);
        else return price;
    }

    public int calculateDiscountedPrice(int price, int discountRate) {
        return price - (price * discountRate / 100);
    }
}
