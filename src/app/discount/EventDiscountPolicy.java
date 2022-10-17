package app.discount;

import java.util.Scanner;

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

    @Override
    public DiscountCondition checkDiscount() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생이십니까? ");
        System.out.println("  (1)_예 (2)_아니오");

        int isCodeStateStudent;
        while (true) {
            isCodeStateStudent = scanner.nextInt();
            if (isCodeStateStudent == 1) return DiscountCondition.CODESTATES_STUDENT;
            else if (isCodeStateStudent == 2) return DiscountCondition.NULL;
            else System.out.println("[🚫] 잘못 입력하셨습니다. 다시 입력해주세요. ");
        }
    }
}
