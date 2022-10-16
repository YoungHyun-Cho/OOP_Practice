import kiosk.AppConfig;
import kiosk.member.Member;
import kiosk.member.MemberRepository;
import kiosk.member.MemoryMemberRepository;
import kiosk.order.Order;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Member member = new Member(0, "조영현", "1030", "대평로 27", "01095128646", 1);
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.addMember(member);
        System.out.println(memberRepository.getMembers()[0].toString());
    }

    public void printDisplay() {

    }

    public void printReceipt(Order order) {

    }
}

/*
* 1. 회원
*   - 회원 가입
*   - 회원 탈퇴
* 2. 주문
*   - 주문 생성
*   - 주문 취소
* 3. 관리자 페이지
*   - 상품 등록
*   - 상품 삭제
*
* 참고
* 각종 정보 수정은 옵셔널
* */

