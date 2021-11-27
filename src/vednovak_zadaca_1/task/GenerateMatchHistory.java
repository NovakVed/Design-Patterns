package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Club;
import vednovak_zadaca_1.data.Event;
import vednovak_zadaca_1.data.Match;
import vednovak_zadaca_1.table.MatchHistory;

import java.util.HashMap;
import java.util.Map;

class GenerateMatchHistory implements Task {
    private final String club;
    private final int round;
    public Map<Integer, MatchHistory> matchHistoryHashMap = new HashMap<>();

    GenerateMatchHistory(String club) {
        this.club = club;
        round = StoredData.matches.get(StoredData.matches.size() - 1).round;
        printTable();
    }

    GenerateMatchHistory(String club, String round) {
        this.club = club;
        this.round = Integer.parseInt(round);
        printTable();
    }

    public void printTable() {
        for (Match match : StoredData.matches) {
            if (match.homeTeam.equals(club) || match.awayTeam.equals(club)) {
                if (match.round <= round) {
                    int goalsFor = 0;
                    int goalsAgainst = 0;

                    for (Event event : StoredData.events) {
                        if (event.getClub() != null) {
                            if (match.matchID == event.getMatchID()) {
                                if (event.getClub().equals(match.homeTeam)) goalsFor += 1;
                                if (event.getClub().equals(match.awayTeam)) goalsAgainst += 1;
                            }
                        }
                    }
                    storeMatchHistoryList(getClubName(match.homeTeam), getClubName(match.awayTeam),
                            goalsFor, goalsAgainst, match.round, match.start);
                }
            }
        }
        System.out.printf("%5s %25s %25s %15s %20s%n",
                "Kolo", "Domaćin", "Gost", "Rezultat", "Datum");
        matchHistoryHashMap.forEach((k, v) ->
                System.out.printf("%5s %25s %25s %15s %20s%n",
                        v.getRound(), v.getHomeTeam(), v.getAwayTeam(), v.getGameScore(), v.getDate())
        );
    }

    private String getClubName(String clubCode) {
        for (Club club : StoredData.clubs) {
            if (club.club.equals(clubCode)) return club.name;
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
}
