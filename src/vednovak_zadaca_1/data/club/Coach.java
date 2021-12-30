package vednovak_zadaca_1.data.club;

public class Coach extends Person {
    public Coach(String clubID, String name) {
        super(clubID, name);
    }

    @Override
    public String toString() {
        return "Klub: " + clubID + ", trener: " + name;
    }

    @Override
    public void showChampionshipMemberDetails() {
        System.out.println(this);
    }
}