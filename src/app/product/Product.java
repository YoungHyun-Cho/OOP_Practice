package app.product;

/*
 * 각 클래스 간 공통적인 필드 및 메서드를 Product 클래스로 묶고,
 * 차이점을 보여주기 위해 Hamburger, Side, Drink 클래스가 가질 수 있는 독자적인 특성을
 * 별도의 필드로 만들었습니다.
 * Hamburger 클래스 : burgerSet      (해당 햄버거를 메인으로 하는 햄버거 세트인지 여부)
 *                   burgerSetPrice (해당 햄버거를 메인으로 하는 햄버거 세트의 가격)
 * Side 클래스      : ketchup        (케찹 갯수)
 * Drink 클래스     : hasStraw       (빨대 사용 여부)
 *
 * 차이점을 굳이 만든 이유
 * : Hamburger, Side, Drink 클래스 간 차이점이 존재하지 않는다면 굳이 이 하위 클래스들을
 * 구분해서 만들 이유가 없을 것으로 생각했습니다.
 * */

public class Product {
    private int id;
    private String name;
    private int price;
    private int kcal;

    public Product(String name, int price, int kcal) {
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }

    public Product(int id, String name, int price, int kcal) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcal = kcal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getKcal() {
        return kcal;
    }
}
