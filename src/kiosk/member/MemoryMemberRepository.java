package kiosk.member;

public class MemoryMemberRepository implements MemberRepository {

    private Member[] members = new Member[0];

    public Member[] getMembers() {
        return members;
    }

    public int addMember(Member member) {
        Member[] newMembers = new Member[members.length + 1];
        System.arraycopy(members, 0, newMembers, 0, members.length);
        newMembers[newMembers.length - 1] = member;
        members = newMembers;
        return member.getId();
    }

    public void deleteMember(int id) {
        Member[] newMembers = new Member[members.length - 1];
        int index = 0;
        for (Member member : members) {
            if (member.getId() == id) newMembers[index++] = member;
        }
    }
}
