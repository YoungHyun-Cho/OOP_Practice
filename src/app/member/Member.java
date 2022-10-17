package app.member;

import app.product.Product;

public class Member {
    private int id;
    private String userName;
    private String password;
    private int orderId;
    private Product[] basket = new Product[0];

    public Member(int id, String userId, String password) {
        this.id = id;
        this.userName = userId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Product[] getBasket() {
        return basket;
    }

    public void addProductIntoBasket(Product product) {
        Product[] newBasket = new Product[basket.length + 1];
        System.arraycopy(basket, 0, newBasket, 0, basket.length);
        newBasket[newBasket.length - 1] = product;
        basket = newBasket;
    }

    public void printBasket() {
        int productNumber = 0;
        int totalPrice = 0;

        System.out.println("[🧺] 장바구니");
        System.out.println("-----------------------------------------");

        for (Product product : basket) {
            System.out.printf("  (%2s) %8s   %4d kcal   %5d 원\n",
                    ++productNumber < 9 ? "_" + productNumber : productNumber,
                    product.getName() ,product.getKcal(), product.getPrice()
            );

            totalPrice += product.getPrice();
        }

        System.out.println("-----------------------------------------");
        System.out.printf("합계 : %6d원\n\n", totalPrice);
        System.out.println("(1)_주문하기 (2)_이전으로");
    }
}
