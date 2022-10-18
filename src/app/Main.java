package app;

public class Main {
    public static void main(String[] args) {

        AppConfigurer appConfig = new AppConfigurer();
        DeliveryApp deliveryApp = new DeliveryApp(
                appConfig.getStoreName(),
                appConfig.productService()
        );

        deliveryApp.start();
    }
}

/*
* 기존의 코드에서 Member, Order와 관련된 코드들을 모두 삭제하였습니다.
* 장바구니에 Product를 담고, 주문하기를 누르면 주문 내용을 출력하기만 하고 프로그램이 종료됩니다.
*
* 과제의 목적
* - [객체지향 프로그래밍 기초]에서 배우는 문법을 직접 활용해본다.
* - [객체지향 프로그래밍 심화]에서 배우는 캡슐화, 상속, 추상화, 다형성이 어떻게 활용될 수 있는지 확인한다.
* - 객체지향적인 설계를 도입했을 때의 장점(변화와 확장에 유연함)을 가볍게 확인해본다.
*
* 이제 곧 코스가 오픈되어 당장의 대폭적인 수정은 어렵지만, 자유롭게 피드백 남겨주세요!!
* 이번 섹션 지나고 나서 수강생들의 피드백과 함께 과제 개선할 때 유용하게 참고하겠습니다.
* */