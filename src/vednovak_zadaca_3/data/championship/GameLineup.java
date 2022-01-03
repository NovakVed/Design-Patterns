package vednovak_zadaca_1.data.championship;

public class GameLineup implements MatchDetails {
    public int matchID;
    public String clubID;
    public String type;
    public String player;
    public String position;

    public GameLineup(int matchID, String clubID, String type, String player, String position) {
        this.matchID = matchID;
        this.clubID = clubID;
        this.type = type;
        this.player = player;
        this.position = position;
    }

    @Override
    public String toString() {
        return "ID: " + matchID + " club: " + clubID + " tip: " + type + " igrač: " + player
                + " pozicija: " + position;
    }

    @Override
    public void showMatchDetails() {
        System.out.println(this);
    }

    @Override
    public String getClubID() {
        return clubID;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPlayer() {
        return player;
    }

    @Override
    public String getMinutes() {
        return null;
    }

    @Override
    public String getSubstitute() {
        return null;
    }
}
