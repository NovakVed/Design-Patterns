package vednovak_zadaca_3.data.championship;

import vednovak_zadaca_3.StoredData;
import vednovak_zadaca_3.data.club.ChampionshipMember;
import vednovak_zadaca_3.data.club.Club;
import vednovak_zadaca_3.data.club.Player;

public class GameLineup extends MatchDetails {
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

    public void showMatchDetails() {
        System.out.println(this);
    }

    public int getMatchID() {
        return matchID;
    }

    public String getClubID() {
        return clubID;
    }

    public String getType() {
        return type;
    }

    public String getPlayerName() {
        return player;
    }

    public Player getPlayer() {
        for (Club club : StoredData.clubs.values()) {
            for (ChampionshipMember member : club.championshipMembers) {
                if (member.getPersonName().equals(this.player)) return member.getPlayer();
            }
        }
        return null;
    }

    public String getPlayerPosition() {
        return position;
    }
}
