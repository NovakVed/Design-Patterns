package vednovak_zadaca_3.data.club;

import vednovak_zadaca_3.data.club.state.InGamePlayerState;

import java.util.List;

public class Player extends Person {
    public List<String> positions;
    public String born;
    private InGamePlayerState inGamePlayerState;

    public Player(String clubID, String name, List<String> positions, String born) {
        super(clubID, name);
        this.positions = positions;
        this.born = born;
    }

    public void setState(InGamePlayerState inGamePlayerState) {
        this.inGamePlayerState = inGamePlayerState;
    }

    public List<String> getPosition() {
        return this.positions;
    }

    public String getClubID() {
        return this.clubID;
    }

    public String getBirthday() {
        return this.born;
    }

    public InGamePlayerState getState() {
        return this.inGamePlayerState;
    }

    @Override
    public String toString() {
        return "Klub: " + clubID + ", igrač: " + name + ", rođen: " + born;
    }

    public void showChampionshipMemberDetails() {
        System.out.println(name);
    }

    public Player getPlayer() {
        return this;
    }
}
