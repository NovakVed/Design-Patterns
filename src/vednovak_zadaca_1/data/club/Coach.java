package vednovak_zadaca_1.data.club;

public class Coach extends Person implements Member {
    public Coach(String clubID, String name) {
        super(clubID, name);
    }

    @Override
    public String toString() {
        return "Klub: " + clubID + ", trener: " + name;
    }

    @Override
    public void showMemberDetails() {
        System.out.println(this);
    }
}