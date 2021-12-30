package vednovak_zadaca_1.data.club;

public class Player extends Person implements Member {
    public String position;
    public String born;

    public Player(String clubID, String name, String position, String born) {
        super(clubID, name);
        this.position = position;
        this.born = born;
    }

    @Override
    public String toString() {
        return "Klub: " + clubID + ", igrač: " + name + ", pozicija: " + position + ", rođen: " + born;
    }

    @Override
    public void showMemberDetails() {
        System.out.println(this);
    }
}
