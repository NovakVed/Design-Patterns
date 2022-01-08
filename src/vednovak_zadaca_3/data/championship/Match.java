package vednovak_zadaca_3.data.championship;

import java.util.ArrayList;
import java.util.List;

public class Match extends MatchDetails {
    public int matchID;
    public int round;
    public String homeTeam;
    public String awayTeam;
    public String start;

    public List<MatchDetails> matchGameLineups = new ArrayList<>();
    public List<MatchDetails> matchEvents = new ArrayList<>();

    public Match(int matchID, int round, String homeTeam, String awayTeam, String start) {
        this.matchID = matchID;
        this.round = round;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.start = start;
    }

    public void addGameLineups(MatchDetails matchDetails) {
        this.matchGameLineups.add(matchDetails);
    }

    public void removeGameLineupObject(int index) {
        this.matchGameLineups.remove(index);
    }

    public void clearGameLineups() {
        this.matchGameLineups.clear();
    }

    public void addEvents(MatchDetails matchDetails) {
        this.matchEvents.add(matchDetails);
    }

    public void removeEventsObject(int index) {
        this.matchEvents.remove(index);
    }

    public void clearEvents() {
        this.matchEvents.clear();
    }

    public List<MatchDetails> getMatchEvents() {
        return matchEvents;
    }

    public List<MatchDetails> getMatchGamePlan() {
        return matchGameLineups;
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
