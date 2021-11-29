package vednovak_zadaca_1.data;

public class Coach extends Person {
    public Coach(String club, String name, String born) {
        super(club, name, born);
    }

    @Override
    public String toString() {
        return "Klub: " + club + ", trener: " + name + ", rođen: " + born;
    }
}
