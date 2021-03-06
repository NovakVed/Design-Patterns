package vednovak_zadaca_3.task;

import vednovak_zadaca_3.StoredData;
import vednovak_zadaca_3.data.championship.Match;
import vednovak_zadaca_3.data.championship.MatchDetails;
import vednovak_zadaca_3.data.club.Club;
import vednovak_zadaca_3.table.MatchHistory;

import java.util.HashMap;
import java.util.Map;

class GenerateMatchHistory implements Table {
    private final String club;
    private final int round;
    public Map<Integer, MatchHistory> matchHistoryHashMap = new HashMap<>();

    GenerateMatchHistory(String club) {
        this.club = club;
        round = StoredData.matches.size();
        generateTable();
    }

    GenerateMatchHistory(String club, String round) {
        this.club = club;
        this.round = Integer.parseInt(round);
        generateTable();
    }

    public void generateTable() {
        for (Match match : StoredData.matches.values()) {
            if (match.homeTeam.equals(club) || match.awayTeam.equals(club)) {
                if (match.round <= round) {
                    int goalsFor = 0;
                    int goalsAgainst = 0;

                    for (MatchDetails matchDetails : match.getMatchEvents()) {
                        if (matchDetails.getClubID() != null) {
                            if (matchDetails.getClubID().equals(match.homeTeam)) {
                                if (matchDetails.getType().equals("1")) goalsFor += 1;
                                if (matchDetails.getType().equals("2")) goalsFor += 1;
                                if (matchDetails.getType().equals("3")) goalsAgainst += 1;
                            }
                            if (matchDetails.getClubID().equals(match.awayTeam)) {
                                if (matchDetails.getType().equals("1")) goalsAgainst += 1;
                                if (matchDetails.getType().equals("2")) goalsAgainst += 1;
                                if (matchDetails.getType().equals("3")) goalsFor += 1;
                            }
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
