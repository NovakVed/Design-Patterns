package vednovak_zadaca_1.data;

public class Player extends Person {
    public String position;

    //TODO promijeni born iz stringa u datum!
    public Player(String club, String name, String position, String born) {
        super(club, name, born);
        this.position = position;
    }

    @Override
    public String toString() {
        return "Klub: " + club + ", igrač: " + name + ", pozicija: " + position + ", rođen: " + born;
    }
}
