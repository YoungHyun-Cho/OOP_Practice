package app.discount;

import java.util.Scanner;

public class CardDiscountPolicy implements DiscountPolicy {

    private int discountRate_samsung = 5;
    private int discountRate_lotte   = 10;


    @Override
    public int discount(DiscountCondition discountCondition, int price) {
        switch (discountCondition) {
            case SAMSUNG_CARD: return calculateDiscountedPrice(price, discountRate_samsung);
            case LOTTE_CARD:   return calculateDiscountedPrice(price, discountRate_lotte);
            default: return price;
        }
    }

    public int calculateDiscountedPrice(int price, int discountRate) {
        return price - (price * discountRate / 100);
    }

    @Override
    public DiscountCondition checkDiscount() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("결제 수단을 선택해주세요. ");
        System.out.println("  (1)_삼성카드 (2)_롯데카드 (3)_현대카드 (4)_하나카드");

        String card = scanner.next();

        switch (card) {
            case "1": return DiscountCondition.SAMSUNG_CARD;
            case "2": return DiscountCondition.LOTTE_CARD;
            case "3":
            case "4": return DiscountCondition.NULL;
            default:
                System.out.println("[🚫] 잘못 입력하셨습니다. 다시 입력해주세요. ");
                return DiscountCondition.NULL;
        }
    }
}
