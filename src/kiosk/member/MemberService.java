package kiosk.member;

public class MemberService {
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int join(Member member) {
        return memberRepository.addMember(member);
    }

    public void withdrawal(int id) {
        memberRepository.deleteMember(id);
    }
}
