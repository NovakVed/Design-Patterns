package vednovak_zadaca_3.data.club;

import java.util.List;

public class Player extends Person {
    public List<String> positions;
    public String born;

    public Player(String clubID, String name, List<String> positions, String born) {
        super(clubID, name);
        this.positions = positions;
        this.born = born;
    }

    @Override
    public String toString() {
        return "Klub: " + clubID + ", igrač: " + name + ", rođen: " + born;
    }

    public void showChampionshipMemberDetails() {
        System.out.println(name);
    }
}
