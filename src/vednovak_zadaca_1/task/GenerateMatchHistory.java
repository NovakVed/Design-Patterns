package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.championship.Match;
import vednovak_zadaca_1.data.championship.MatchDetails;
import vednovak_zadaca_1.data.club.Club;
import vednovak_zadaca_1.table.MatchHistory;

import java.util.HashMap;
import java.util.Map;

class GenerateMatchHistory implements Table {
    private final String club;
    private final int round;
    public Map<Integer, MatchHistory> matchHistoryHashMap = new HashMap<>();

    GenerateMatchHistory(String club) {
        this.club = club;
        round = StoredData.matches.size();
        printTable();
    }

    GenerateMatchHistory(String club, String round) {
        this.club = club;
        this.round = Integer.parseInt(round);
        printTable();
    }

    public void printTable() {
        for (Match match : StoredData.matches.values()) {
            if (match.homeTeam.equals(club) || match.awayTeam.equals(club)) {
                if (match.round <= round) {
                    int goalsFor = 0;
                    int goalsAgainst = 0;

                    for (MatchDetails matchDetails : match.matchEvents) {
                        if (matchDetails.getClubID() != null) {
                            if (matchDetails.getClubID().equals(match.homeTeam)) goalsFor += 1;
                            if (matchDetails.getClubID().equals(match.awayTeam)) goalsAgainst += 1;
                        }
                    }
                    storeMatchHistoryList(getClubName(match.homeTeam), getClubName(match.awayTeam),
                            goalsFor, goalsAgainst, match.round, match.start);
                }
            }
        }
    }

    private String getClubName(String clubCode) {
        for (Club club : StoredData.clubs.values()) {
            if (club.clubID.equals(clubCode)) return club.name;
        }
        return null;
    }

    private void storeMatchHistoryList(String homeTeam, String awayTeam, int goalsFor,
                                       int goalsAgainst, int round, String start) {
        MatchHistory matchHistory = new MatchHistory.Builder()
                .setRound(round)
                .setHomeTeam(homeTeam)
                .setAwayTeam(awayTeam)
                .setGameScore(goalsFor + " : " + goalsAgainst)
                .setDate(start)
                .build();
        matchHistoryHashMap.put(round, matchHistory);
    }

    @Override
    public void accept(TableVisitor tableVisitor) {
        tableVisitor.visit(this);
    }
}
