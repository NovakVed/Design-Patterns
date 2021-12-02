package vednovak_zadaca_1.data.championship;

import java.util.ArrayList;
import java.util.List;

public class Match implements MatchDetails {
    public int matchID;
    public int round;
    public String homeTeam;
    public String awayTeam;
    public String start;

    public List<MatchDetails> matchEvents = new ArrayList<>();
    public List<MatchDetails> matchGameLineups = new ArrayList<>();

    public Match(int matchID, int round, String homeTeam, String awayTeam, String start) {
        this.matchID = matchID;
        this.round = round;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.start = start;
    }

    public void addMatchEvents(MatchDetails matchDetails) {
        this.matchEvents.add(matchDetails);
    }

    public void removeMatchEvents(MatchDetails matchDetails) {
        this.matchEvents.remove(matchDetails);
    }

    public void clearMatchEvents() {
        System.out.println("Kolo: " + round + ", briše sva kola");
        this.matchEvents.clear();
    }

    public void addMatchGameLineups(MatchDetails matchDetails) {
        this.matchGameLineups.add(matchDetails);
    }

    public void removeMatchGameLineups(MatchDetails matchDetails) {
        this.matchGameLineups.remove(matchDetails);
    }

    public void clearMatchGameLineups() {
        System.out.println("Kolo: " + round + ", briše sva kola");
        this.matchGameLineups.clear();
    }

    @Override
    public String toString() {
        return "ID: " + matchID + " kolo: " + round + " domaćin: " + homeTeam + " gost: " + awayTeam
                + " početak: " + start;
    }

    @Override
    public void showMatchDetails() {
        System.out.println(this);
    }

    @Override
    public String getClubID() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getPlayer() {
        return null;
    }
}
