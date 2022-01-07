package vednovak_zadaca_3.data.club;

import java.util.ArrayList;
import java.util.List;

public class Club extends ChampionshipMember {
    public String clubID;
    public String name;
    public String coach;

    public List<ChampionshipMember> championshipMembers = new ArrayList<>();

    public Club(String clubID, String name, String coach) {
        this.clubID = clubID;
        this.name = name;
        this.coach = coach;
    }

    public void add(ChampionshipMember member) {
        this.championshipMembers.add(member);
    }

    public String getClubID() {
        return this.clubID;
    }

    public String getClubName() {
        return this.name;
    }

    public String getCoachName() {
        return this.coach;
    }

    @Override
    public String toString() {
        return "Klub: " + clubID + " naziv: " + name + " trener: " + coach;
    }

    public void showChampionshipMemberDetails() {
        for (ChampionshipMember member : championshipMembers) {
            member.showChampionshipMemberDetails();
        }
    }
}
