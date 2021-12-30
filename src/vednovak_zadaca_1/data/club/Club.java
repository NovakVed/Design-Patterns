package vednovak_zadaca_1.data.club;

import java.util.ArrayList;
import java.util.List;

public class Club extends ChampionshipMember {
    public String clubID;
    public String name;
    public String coach;

    public List<ChampionshipMember> members = new ArrayList<>();

    public Club(String clubID, String name, String coach) {
        this.clubID = clubID;
        this.name = name;
        this.coach = coach;
    }

    public void add(ChampionshipMember member) {
        this.members.add(member);
    }

    public void remove(ChampionshipMember member) {
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

    public ChampionshipMember getChampionshipMember(int componentID) {
        return super.getChampionshipMember(componentID);
    }

    public void showChampionshipMemberDetails() {
        for (ChampionshipMember member : members) {
            member.showChampionshipMemberDetails();
        }
    }
}
