package kiosk.member;

public interface MemberRepository {
    Member[] getMembers();
    int addMember(Member member);
    void deleteMember(int id);
}
