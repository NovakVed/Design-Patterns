package vednovak_zadaca_1.data;

public class GameLineup {
    public int number;
    public String club;
    public String type;
    public String player;
    public String position;

    public GameLineup(int number, String club, String type, String player, String position) {
        this.number = number;
        this.club = club;
        this.type = type;
        this.player = player;
        this.position = position;
    }

    @Override
    public String toString() {
        return "ID: " + number + " club: " + club + " tip: " + type + " igrač: " + player
                + " pozicija: " + position;
    }
}
