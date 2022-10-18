package app.product.subproduct;

import app.product.Product;

/*
 * 각 클래스 간 공통적인 필드 및 메서드를 Product 클래스로 묶고,
 * 차이점을 보여주기 위해 Hamburger, Side, Drink 클래스가 가질 수 있는 독자적인 특성을
 * 별도의 필드로 만들었습니다.
 * Hamburger 클래스 : burgerSet      (해당 햄버거를 메인으로 하는 햄버거 세트인지 여부)
 *                   burgerSetPrice (해당 햄버거를 메인으로 하는 햄버거 세트의 가격)
 * Side 클래스      : ketchup        (케찹 갯수)
 * Drink 클래스     : hasStraw       (빨대 사용 여부)
 * */

public class Hamburger extends Product {

    private boolean burgerSet;
    private int burgerSetPrice;

    public Hamburger(int id, String name, int price, int kcal, boolean burgerSet, int burgerSetPrice) {
        super(id, name, price, kcal);
        this.burgerSet = burgerSet;
        this.burgerSetPrice = burgerSetPrice;
    }

    /*
     * 깊은 복사를 위한 복사 생성자입니다.
     *
     * 깊은 복사를 하는 이유
     * 예를 들어, 사용자가 감자튀김을 장바구니에 담으면서 옵션으로 케첩 5개를 입력한 경우,
     * 장바구니에는 ketchup이 5인 감자튀김 객체의 참조가 담깁니다.
     * 이 다음에 새우버거세트를 선택하면서 동일하게 감자튀김을 장바구니에 담는 경우,
     * 케첩을 3개로 입력하면 이전에 입력한 케첩 갯수 5가 3으로 덮여씌워집니다.
     *
     * 따라서, 전혀 다른 객체를 생성하고자 복사 생성자를 활용하여 깊은 복사로 인스턴스를 만들어
     * 장바구니에 저장하는 식으로 로직을 짰습니다.
     *
     * 깊은 복사와 얕은 복사에 관해서는 콘텐츠 내에서 쉽게 풀어서 설명할 예정입니다.
     * */
    public Hamburger(Hamburger hamburger) {
        super(hamburger.getName(), hamburger.getPrice(), hamburger.getKcal());
        this.burgerSet = hamburger.isBurgerSet();
        this.burgerSetPrice = getBurgerSetPrice();
    }

    public boolean isBurgerSet() {
        return burgerSet;
    }

    public void setBurgerSet(boolean burgerSet) {
        this.burgerSet = burgerSet;
    }

    public int getBurgerSetPrice() {
        return burgerSetPrice;
    }
}
