package app;

import app.discount.DiscountCondition;
import app.discount.DiscountPolicy;
import app.member.Member;
import app.member.MemberService;
import app.order.Order;
import app.order.OrderService;
import app.product.Product;
import app.product.ProductService;
import java.util.Scanner;

public class DeliveryApp {

    MemberService memberService;
    OrderService orderService;
    ProductService productService;
    DiscountPolicy[] discountPolicies;
    Member member;
    Order order;

    public DeliveryApp(MemberService memberService, OrderService orderService, ProductService productService, DiscountPolicy[] discountPolicies) {
        this.memberService = memberService;
        this.orderService = orderService;
        this.productService = productService;
        this.discountPolicies = discountPolicies;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        // 회원 가입 및 로그인
        while (true) {

            System.out.println("  (1)_로그인 (2)_회원가입");

            String auth = scanner.nextLine();

            if (auth.equals("1")) {

                System.out.println("[🔑] 로그인");

                System.out.print("ID : ");
                String userName = scanner.nextLine();

                System.out.print("PW : ");
                String password = scanner.nextLine();

                member = memberService.signIn(userName, password);

                if (member == null) System.out.println("[🚫] 존재하지 않는 회원이거나 잘못된 비밀번호를 입력하셨습니다. ");
                else {
                    System.out.println("[📣]" + userName + " 님 환영합니다. ");
                    break;
                }
            }

            else if (auth.equals("2")) {
                System.out.println("📝 회원가입");

                System.out.print("ID : ");
                String userName = scanner.nextLine();

                System.out.print("PW : ");
                String password = scanner.nextLine();

                System.out.print("주소 : ");
                String address = scanner.nextLine();

                memberService.signUp(userName, password, address);

                System.out.println("[📣] 가입을 환영합니다. ");
            }

            else System.out.println("[🚫] 잘못 입력하셨습니다. 다시 입력해주세요. ");
        }


        // 주문
        Product[] products = productService.getAllProduct();

        SelectMenu:
        while (true) {
            System.out.println("[📣] 메뉴를 골라주세요.");
            System.out.println("-----------------------------------------");

            for (Product product : products) {
                System.out.printf("  (%2s) %8s   %4d kcal   %5d 원\n",
                        product.getId() < 9 ? "_" + (product.getId() + 1) : product.getId() + 1,
                        product.getName() ,product.getKcal(), product.getPrice());
            }
            System.out.println("  (_0) 장바구니");

            int menuChoice;

            while (true) {
                menuChoice = scanner.nextInt();
                if (menuChoice == 0) {
                    member.printBasket();

                    int exitBasket;

                    while (true) {
                        exitBasket = scanner.nextInt();
                        if (exitBasket == 1) {
                            System.out.println("[📣] 주문을 진행합니다. ");

                            DiscountCondition[] discountConditions = new DiscountCondition[discountPolicies.length];

                            for (int i = 0; i < discountPolicies.length; i++) {
                                discountConditions[i] = discountPolicies[i].checkDiscount();
                            }

                            order = orderService.createOrder(member.getId(), member.getBasket(), discountConditions);
                            member.setOrderId(order.getId());

                            System.out.println("[✅] 주문이 완료되었습니다.");
                            System.out.println("[📣] 주문 내역");
                            System.out.println("-----------------------------------------");

                            for (Product product : order.getProducts()) {
                                System.out.println("  " + product.getName());
                            }

                            System.out.println("-----------------------------------------");
                            System.out.printf("  결제하실 금액 : %7d\n\n", order.getFinalPrice());
                            System.out.printf("[📣] 상품을 준비하여 %s(으)로 배송합니다.\n", member.getAddress());
                            break SelectMenu;

                        }
                        else if (exitBasket == 2) continue SelectMenu;
                        else System.out.println("[🚫] 잘못 입력하셨습니다. 다시 입력해주세요. ");
                    }

                }

                else if (1 <= menuChoice && menuChoice <= products.length) {
                    member.addProductIntoBasket(productService.getProduct(menuChoice - 1));
                    System.out.println("[📣] 장바구니에 상품이 추가되었습니다. ");
                    break;
                }

                else System.out.println("[🚫] 잘못 입력하셨습니다. 다시 입력해주세요. ");
            }
        }
        System.out.println("[📣] 주문 프로그램을 종료합니다. 이용해주셔서 감사합니다. ");
    }
}
