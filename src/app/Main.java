package app;

public class Main {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        DeliveryApp deliveryApp = new DeliveryApp(
                appConfig.memberService(),
                appConfig.orderService(),
                appConfig.productService(),
                appConfig.discountPolicies()
        );

        System.out.printf("%s Delivery Service\n", appConfig.getStoreName());
        deliveryApp.start();
    }
}

/*
* 1. 회원
*   - 회원 가입
*   - 로그인
* 2. 주문
*   - 주문 생성
*
* 질문
* 1. 기능의 디테일함 적정 여부
*   - 각종 정보 수정 기능 -> 회원 정보, 장바구니 상품 수정 등
*   - 회원 탈퇴 및 주문 취소 등
* */

