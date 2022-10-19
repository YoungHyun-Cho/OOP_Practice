package app;

import app.product.Product;
import app.product.ProductService;
import app.product.subproduct.BurgerSet;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class Cart {
    private Product[] items = new Product[0];
    private boolean ordered = false;

    public boolean isOrdered() {
        return ordered;
    }

    // 사용자가 메뉴를 선택하면 장바구니에 해당 상품을 담습니다.
    public void addToCart(Product product) {

        /*
        * 복사 생성자를 통한 깊은 복사로 장바구니에 넣을 product를 새롭게 생성합니다.
        * 깊은 복사를 사용하는 이유는 subproduct 패키지 내의 클래스들의 복사 생성자 상단에 설명해두었습니다.
        * */

        Product newProduct;

        if (product instanceof Hamburger) newProduct = new Hamburger((Hamburger) product);
        else if (product instanceof Side) newProduct = new Side((Side) product);
        else if (product instanceof Drink) newProduct = new Drink((Drink) product);
        else newProduct = new BurgerSet((BurgerSet) product);

        /*
         * 배열의 길이 확장과 복사
         * 컬렉션을 사용하면 편리하지만, 아직 수강생들이 컬렉션을 배우지 않은 시점이라
         * 일단은 배열을 사용하였습니다.
         *
         * System.arraycopy를 활용한 배열의 길이 확장과 복사는 [Java 기초] 유닛의 연습문제에서
         * 많이 다루기 때문에 수강생들에게 크게 어렵지 않게 느껴질 것으로 생각됩니다.
         * */

        Product[] newItems = new Product[items.length + 1];
        System.arraycopy(items, 0, newItems, 0, items.length);
        newItems[newItems.length - 1] = newProduct;
        items = newItems;
    }

    public void printCart() {
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(50));
        printDetails();
        System.out.println("-".repeat(50));
        System.out.printf("합계 : %d원\n", getTotalPrice());

        System.out.println("(1)_이전으로 (2)_주문하기");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("2")) makeOrder();
    }

    public void printDetails() {

        for (Product product : items) {
            if (product instanceof BurgerSet) {
                BurgerSet burgerSet = (BurgerSet) product;
                System.out.printf(
                        "  %s %6d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        product.getName(),
                        product.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasStraw() ? "있음" : "없음"
                );
            }
            else if (product instanceof Side) {
                System.out.printf(
                        "  %s %6d원 (케첩 %d개)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getKetchup()
                );
            }
            else if (product instanceof Drink) {
                System.out.printf(
                        "  %s %6d원 (빨대 %s)\n",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).hasStraw() ? "있음" : "없음"
                );
            }
        }
    }

    public void makeOrder() {

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(50));
        printDetails();
        System.out.println("-".repeat(50));
        System.out.printf("합계 : %d원\n\n", getTotalPrice());
        ordered = true;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : items) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
