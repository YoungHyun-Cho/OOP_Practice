package app;

import app.product.Product;
import app.product.ProductService;
import app.product.subproduct.BurgerSet;
import app.product.subproduct.Drink;
import app.product.subproduct.Hamburger;
import app.product.subproduct.Side;

import java.util.Scanner;

public class DeliveryApp {

    private String storeName; // AppConfigurer에서 설정한 storeName
    private ProductService productService; // AppConfigurer로부터 DI
    private Scanner scanner = new Scanner(System.in);
    private Cart cart = new Cart(); // 장바구니


    public DeliveryApp(String storeName, ProductService productService) {
        this.storeName = storeName;
        this.productService = productService;
    }

    public void start() {

        // 수강생들이 아직 컬렉션을 배우지 않았으므로 배열을 사용하였습니다.
        Product[] products = productService.getAllProduct();

        System.out.printf("%s Delivery Service\n", storeName);

        /*
        * 메인 로직을 담고 있는 반복문입니다.
        * 주문이 완료되면 cart.ordered의 값이 true로 바뀌며, 이 때 반복문을 탈출합니다.
        * */
        while (true) {

            // 메뉴 출력
            printMenu(products);

            // 메뉴 출력 후, 품목을 장바구니에 담거나, 장바구니로 이동합니다.
            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) cart.printCart();
            else if (1 <= input && input <= products.length) addToCart(input);

            if (cart.isOrdered()) break;
        }

        System.out.println("이용해주셔서 감사합니다.");
        System.out.println("프로그램을 종료합니다.");
    }

    public void printMenu(Product[] products) {

        /*
        * 메뉴를 출력해줍니다.
        * printSides와 printDrinks는 재사용이 필요하여 메서드로 추출하였고,
        * printHamburgers는 재사용이 필요하지는 않지만, 일관된 형식으로 코드를 작성하는 것이
        * 수강생에게 혼동의 여지가 적을 것 같아 동일하게 메서드로 추출하였습니다.
        *
        * */

        System.out.println("[🔻] 메뉴");
        System.out.println("-".repeat(60));

        printHamburgers(products, false);
        printSides(products, false);
        printDrinks(products, false);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");
    }

    public void printHamburgers(Product[] products, boolean isBurgerSet) {
        System.out.println("🍔 햄버거");
        for (Product product : products) {
            if (product instanceof Hamburger) printMenuItem(product, isBurgerSet);
        }
        System.out.println();
    }

    public void printSides(Product[] products, boolean isBurgerSet) {
        System.out.println("🍟 사이드");
        for (Product product : products) {
            if (product instanceof Side) printMenuItem(product, isBurgerSet);
        }
        System.out.println();
    }

    public void printDrinks(Product[] products, boolean isBurgerSet) {
        System.out.println("🥤 음료");
        for (Product product : products) {
            if (product instanceof Drink) printMenuItem(product, isBurgerSet);
        }
        System.out.println();
    }

    /*
     * printMenuItem - isBurgerSet 설명
     * 메뉴에서 햄버거를 선택하면 단품 및 세트를 선택할 수 있습니다.
     * 세트를 선택하면 사이드와 드링크를 추가로 골라서 세트를 구성할 수 있습니다.
     * 세트의 경우에는 전체 햄버거 세트의 가격이 미리 정해져 있으므로
     * 세트를 구성할 때에는 사이드와 드링크의 가격 표시가 필요하지 않습니다.
     * 따라서, 이 두 가지 경우를 구분하기 위해 매개 변수 isBurgerSet을 선언하여 사용하였습니다.
     * */

    public void printMenuItem(Product product, boolean isBurgerSet) {
        if (isBurgerSet) System.out.printf("   (%d) %s %5dKcal\n", product.getId(), product.getName(), product.getKcal());
        else System.out.printf("   (%d) %s %5dKcal %5d원\n", product.getId(), product.getName(), product.getKcal(), product.getPrice());
    }

    /*
    * addToCart
    * 사용자가 메뉴를 선택하면 장바구니에 해당 상품을 담습니다.
    *
    * 컬렉션을 사용하면 편리하지만, 아직 수강생들이 컬렉션을 배우지 않은 시점이라 일단은 배열을 사용하였습니다.
    *
    * System.arraycopy를 활용한 배열의 길이 확장과 복사는 [Java 기초] 유닛의 연습문제에서 많이 다루기 때문에
    * 수강생들에게 크게 어렵지 않게 느껴질 것으로 생각됩니다.
    * */
    public void addToCart(int productId) {

        Product product = productService.getProduct(productId);
        chooseOption(product);

        if (product instanceof Hamburger) {
            Hamburger hamburger = (Hamburger) product;
            if (hamburger.isBurgerSet()) product = composeSet(hamburger);
        }

        cart.addToCart(product);
        System.out.printf("[📣] %s를 장바구니에 담았습니다.\n", product.getName());
    }

    /*
    * product에 따라 선택할 수 있는 옵션을 알려주고, 선택 내용을 setter를 통해 기록해주는 메서드입니다.
    * */
    public void chooseOption(Product product) {

        Scanner scanner = new Scanner(System.in);
        String input;

        if (product instanceof Hamburger) {
            System.out.printf("단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)\n", product.getPrice(), ((Hamburger) product).getBurgerSetPrice());
            input = scanner.nextLine();
            if (input.equals("2")) ((Hamburger) product).setBurgerSet(true);
        }
        else if (product instanceof Side) {
            System.out.println("케첩은 몇개가 필요하신가요?");
            input = scanner.nextLine();
            ((Side) product).setKetchup(Integer.parseInt(input));
        }
        else if (product instanceof Drink) {
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            input = scanner.nextLine();
            if (input.equals("2")) ((Drink) product).setStraw(false);
        }
    }

    // 햄버거 세트를 구성하는 메서드입니다.
    public BurgerSet composeSet(Hamburger hamburger) {

        // 감자튀김, 어니언링 중에서 선택
        System.out.println("사이드를 골라주세요.");
        printSides(productService.getAllProduct(), true);

        String selectSide = scanner.nextLine();
        Side side = (Side) productService.getProduct(Integer.parseInt(selectSide));
        chooseOption(side);

        // 코카콜라, 제로콜라 중에서 선택
        System.out.println("음료를 골라주세요.");
        printDrinks(productService.getAllProduct(), true);

        String selectDrink = scanner.nextLine();
        Drink drink = (Drink) productService.getProduct(Integer.parseInt(selectDrink));
        chooseOption(drink);

        // 햄버거 세트 객체에 필요한 정보 구성 후 햄버거 세트 인스턴스 생성
        String name = hamburger.getName() + "세트";
        int price = hamburger.getBurgerSetPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();

        return new BurgerSet(name, price, kcal, hamburger, side, drink);
    }
}
