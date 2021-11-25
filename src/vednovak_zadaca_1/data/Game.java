package vednovak_zadaca_1.data;

public class Game {
    public int number;
    public int matchesPlayed;
    public String home;
    public String away;
    public String start;
    //TODO promijeni start u timestamp

    public Game(int number, int matchesPlayed, String home, String away, String start) {
        this.number = number;
        this.matchesPlayed = matchesPlayed;
        this.home = home;
        this.away = away;
        this.start = start;
    }

    @Override
    public String toString() {
        return "ID: " + number + " kolo: " + matchesPlayed + " domaćin: " + home + " gost: " + away
                + " početak: " + start;
    }
}
