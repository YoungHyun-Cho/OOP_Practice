package app.member;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signUp(String userName, String password) {
        int lastIndex = memberRepository.findAll().length;
        memberRepository.addMember(new Member(lastIndex, userName, password));
    }

    public Member signIn(String userName, String password) {
        Member member = memberRepository.findByUserName(userName);
        if (member == null) return null;
        else if (member.getPassword().equals(password)) return member;
        else return null;
    }
}
