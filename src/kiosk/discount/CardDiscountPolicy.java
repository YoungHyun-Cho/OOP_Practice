package kiosk.discount;

public class CardDiscountPolicy implements DiscountPolicy {

    private String name = "카드 할인";

    private int discountRate_hana    = 2;
    private int discountRate_samsung = 3;
    private int discountRate_lotte   = 4;
    private int discountRate_hyundai = 5;


    @Override
    public int discount(DiscountCondition discountCondition, int price) {
        switch (discountCondition) {
            case HANA_CARD:    return calculateDiscountedPrice(price, discountRate_hana);
            case SAMSUNG_CARD: return calculateDiscountedPrice(price, discountRate_samsung);
            case LOTTE_CARD:   return calculateDiscountedPrice(price, discountRate_lotte);
            case HYUNDAI_CARD: return calculateDiscountedPrice(price, discountRate_hyundai);
            default: return price;
        }
    }

    public int calculateDiscountedPrice(int price, int discountRate) {
        return price - (price * discountRate / 100);
    }
}
