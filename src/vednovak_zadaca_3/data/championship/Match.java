package vednovak_zadaca_3.data.championship;

import java.util.ArrayList;
import java.util.List;

public class Match extends MatchDetails {
    public int matchID;
    public int round;
    public String homeTeam;
    public String awayTeam;
    public String start;

    public List<MatchDetails> matchDetails = new ArrayList<>();

    public Match(int matchID, int round, String homeTeam, String awayTeam, String start) {
        this.matchID = matchID;
        this.round = round;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.start = start;
    }

    public void add(MatchDetails matchDetails) {
        this.matchDetails.add(matchDetails);
    }

    public List<MatchDetails> getMatchEvents() {
        List<MatchDetails> events = new ArrayList<>();
        for (MatchDetails matchDetails : matchDetails) {
            try {
                if (!matchDetails.getMinutes().isEmpty()) events.add(matchDetails);
            } catch (UnsupportedOperationException ignored) {

            }
        }
        return events;
    }

    public List<MatchDetails> getMatchGamePlan() {
        List<MatchDetails> gameLineups = new ArrayList<>();
        for (MatchDetails matchDetails : matchDetails) {
            try {
                if (!matchDetails.getPlayerPosition().isEmpty()) gameLineups.add(matchDetails);
            } catch (UnsupportedOperationException ignored) {

            }
        }
        return gameLineups;
    }

    public int getMatchID() {
        return matchID;
    }

    public int getRound() {
        return round;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getMatchStart() {
        return start;
    }

    @Override
    public String toString() {
        return "ID: " + matchID + " kolo: " + round + " domaćin: " + homeTeam + " gost: " + awayTeam
                + " početak: " + start;
    }

    public void showMatchDetails() {
        System.out.println(this);
    }
}
