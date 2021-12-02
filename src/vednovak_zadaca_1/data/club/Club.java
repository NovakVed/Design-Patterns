package vednovak_zadaca_1.data.club;

import java.util.ArrayList;
import java.util.List;

public class Club implements Member {
    public String clubID;
    public String name;
    public String coach;

    public List<Member> members = new ArrayList<>();

    public Club(String clubID, String name, String coach) {
        this.clubID = clubID;
        this.name = name;
        this.coach = coach;
    }

    public void add(Member member) {
        this.members.add(member);
    }

    public void remove(Member member) {
        this.members.remove(member);
    }

    public void clear() {
        System.out.println("Klub: " + name + ", briše sve članove kluba");
        this.members.clear();
    }

    @Override
    public String toString() {
        return "Klub: " + clubID + " naziv: " + name + " trener: " + coach;
    }

    @Override
    public void showMemberDetails() {
        for (Member member : members) {
            member.showMemberDetails();
        }
    }
}
