package app.product.subproduct;

/*
* 객체 간 포함 관계를 보여주기 위한 BurgerSet 클래스입니다.
* BurgerSet 인스턴스는 Hamburger, Side, Drink 인스턴스를 포함하며,
* 각 항목에 어떤 인스턴스가 포함될지는 주문자의 선택에 따라 달라집니다.
* */

import app.product.Product;

public class BurgerSet extends Product {

    private Hamburger hamburger;
    private Side side;
    private Drink drink;

    public BurgerSet(String name, int price, int kcal, Hamburger hamburger, Side side, Drink drink) {
        super(name, price, kcal);
        this.hamburger = hamburger;
        this.side = side;
        this.drink = drink;
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
    public BurgerSet(BurgerSet burgerSet) {
        super(burgerSet.getName(), burgerSet.getPrice(), burgerSet.getKcal());
        this.hamburger = new Hamburger(burgerSet.hamburger);
        this.side = new Side(burgerSet.side);
        this.drink = new Drink(burgerSet.drink);
    }

    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }
}
