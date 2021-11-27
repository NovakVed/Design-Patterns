package vednovak_zadaca_1.data;

public class Match {
    public int matchID;
    public int round;
    public String homeTeam;
    public String awayTeam;
    public String start;
    //TODO promijeni start u timestamp

    public Match(int matchID, int round, String home, String awayTeam, String start) {
        this.matchID = matchID;
        this.round = round;
        this.homeTeam = home;
        this.awayTeam = awayTeam;
        this.start = start;
    }

    @Override
    public String toString() {
        return "ID: " + matchID + " kolo: " + round + " domaćin: " + homeTeam + " gost: " + awayTeam
                + " početak: " + start;
    }
}
