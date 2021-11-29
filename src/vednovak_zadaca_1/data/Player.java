package vednovak_zadaca_1.data;

public class Player {
    public String club;
    public String player;
    public String position;
    public String born;

    //TODO promijeni born iz stringa u datum!
    public Player(String club, String player, String position, String born) {
        this.club = club;
        this.player = player;
        this.position = position;
        this.born = born;
    }

    @Override
    public String toString() {
        return "Klub: " + club + " igrač: " + player + " pozicija: " + position + " rođen: " + born;
    }
}
