package app.member;

public class MemoryMemberRepository implements MemberRepository {

    private Member[] members = new Member[0];

    @Override
    public int addMember(Member member) {
        Member[] newMembers = new Member[members.length + 1];
        System.arraycopy(members, 0, newMembers, 0, members.length);
        newMembers[newMembers.length - 1] = member;
        members = newMembers;
        return member.getId();
    }

    @Override
    public Member findByUserName(String userName) {
        for (Member member : members) {
            if (member.getUserName().equals(userName)) return member;
        }
        return null;
    }

    @Override
    public Member[] findAll() {
        return members;
    }
}
