package app.discount;

import java.util.Scanner;

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

    @Override
    public DiscountCondition checkDiscount() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("결제 수단을 선택해주세요. ");
        System.out.println("  (1)_하나카드 (2)_삼성카드 (3)_롯데카드 (4)_현대카드 (5)_신한카드 (6)_우리카드 (7)_국민카드");

        String card = scanner.next();

        switch (card) {
            case "1": return DiscountCondition.HANA_CARD;
            case "2": return DiscountCondition.SAMSUNG_CARD;
            case "3": return DiscountCondition.LOTTE_CARD;
            case "4": return DiscountCondition.HYUNDAI_CARD;
            case "5":
            case "6":
            case "7": return DiscountCondition.NULL;
            default:
                System.out.println("[🚫] 잘못 입력하셨습니다. 다시 입력해주세요. ");
                return DiscountCondition.NULL;
        }
    }
}
