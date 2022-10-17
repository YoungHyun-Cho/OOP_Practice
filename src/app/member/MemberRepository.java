package app.member;

public interface MemberRepository {
    int addMember(Member member);
    Member findByUserName(String userName);
    Member[] findAll();
}
