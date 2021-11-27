package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Club;
import vednovak_zadaca_1.data.Event;
import vednovak_zadaca_1.data.Match;
import vednovak_zadaca_1.table.LeagueTable;

import java.util.*;

class GenerateLeagueTable implements Task {
    private final int round;
    public Map<String, LeagueTable> leagueLeaderboards = new HashMap<>();

    GenerateLeagueTable() {
        this.round = StoredData.matches.get(StoredData.matches.size() - 1).matchID;
        printTable();
    }

    GenerateLeagueTable(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    public void printTable() {
        for (Match match : StoredData.matches) {
            if (match.round <= round) {
                String teamWon = "";
                String teamLost = "";
                int scoredGoalsWonTeam = 0;
                int scoredGoalsLostTeam = 0;

                int scoredGoalsHomeTeam = 0;
                int scoredGoalsAwayTeam = 0;
                for (Event event : StoredData.events) {
                    if (match.matchID == event.getMatchID()) {
                        if (event.getClub() != null) {
                            if (event.getClub().equals(match.homeTeam)) {
                                if (event.getType().equals("1")) scoredGoalsHomeTeam += 1;
                                if (event.getType().equals("2")) scoredGoalsHomeTeam += 1;
                                if (event.getType().equals("3")) scoredGoalsAwayTeam += 1;
                            }
                            if (event.getClub().equals(match.awayTeam)) {
                                if (event.getType().equals("1")) scoredGoalsAwayTeam += 1;
                                if (event.getType().equals("2")) scoredGoalsAwayTeam += 1;
                                if (event.getType().equals("3")) scoredGoalsHomeTeam += 1;
                            }
                        }
                    }
                }
                if (scoredGoalsHomeTeam > scoredGoalsAwayTeam) {
                    teamWon = match.homeTeam;
                    teamLost = match.awayTeam;
                    scoredGoalsWonTeam = scoredGoalsHomeTeam;
                    scoredGoalsLostTeam = scoredGoalsAwayTeam;
                }
                if (scoredGoalsAwayTeam > scoredGoalsHomeTeam) {
                    teamWon = match.awayTeam;
                    teamLost = match.homeTeam;
                    scoredGoalsWonTeam = scoredGoalsAwayTeam;
                    scoredGoalsLostTeam = scoredGoalsHomeTeam;
                }
                String teamWonFullName = "";
                String teamLostFullName = "";
                String home = "";
                String away = "";
                for (Club club : StoredData.clubs) {
                    if (club.club.equals(teamWon)) teamWonFullName = club.name;
                    if (club.club.equals(teamLost)) teamLostFullName = club.name;
                    if (club.club.equals(match.homeTeam)) home = club.name;
                    if (club.club.equals(match.awayTeam)) away = club.name;
                }
                if (scoredGoalsHomeTeam == scoredGoalsAwayTeam) {
                    drawGame(match.round, home, away, scoredGoalsHomeTeam, scoredGoalsAwayTeam);
                }

                wonGame(match.round, teamWonFullName, scoredGoalsWonTeam, scoredGoalsLostTeam);
                lostGame(match.round, teamLostFullName, scoredGoalsLostTeam, scoredGoalsWonTeam);
            }
        }
        if (!leagueLeaderboards.isEmpty()) { //SORTIRANJE PO BODOVIMA!!
            Set<Map.Entry<String, LeagueTable>> entrySet = leagueLeaderboards.entrySet();
            List<Map.Entry<String, LeagueTable>> list = new ArrayList<>(entrySet);
            Collections.sort(list, ((o1, o2) -> o2.getValue().getPoints() - o1.getValue().getPoints()));
            System.out.printf("%20s %6s %6s %6s %6s %6s %6s %6s %10s%n",
                    "Klub", "Kolo", "DO", "NE", "IZ", "ZA", "PG", "Razlika", "Bodovi");

            list.forEach(k ->
                    System.out.printf("%20s %6s %6s %6s %6s %6s %6s %6s %10s%n",
                            k.getValue().getClub(), k.getValue().getMatchesPlayed(),
                            k.getValue().getWon(), k.getValue().getDrawn(), k.getValue().getLost(),
                            k.getValue().getGoalsFor(), k.getValue().getGoalsAgainst(),
                            k.getValue().getGoalsDifference(), k.getValue().getPoints()));
        }
    }

    private void wonGame(int matchesPlayed, String wonTeam, int scoredGoalsWonTeam, int scoredGoalsLostTeam) {
        if (!wonTeam.isEmpty() && !wonTeam.isBlank()) {
            if (!leagueLeaderboards.containsKey(wonTeam)) {
                LeagueTable leagueTable = new LeagueTable.Builder()
                        .setClub(wonTeam)
                        .setMatchesPlayed(matchesPlayed)
                        .setGoalsFor(scoredGoalsWonTeam)
                        .setGoalsAgainst(scoredGoalsLostTeam)
                        .setGoalsDifference(scoredGoalsWonTeam - scoredGoalsLostTeam)
                        .setWon(1)
                        .setLost(0)
                        .setDrawn(0)
                        .setPoints(3)
                        .build();
                leagueLeaderboards.put(wonTeam, leagueTable);
            } else {
                LeagueTable club = leagueLeaderboards.get(wonTeam);
                club.matchesPlayed = matchesPlayed;
                club.won = club.getWon() + 1;
                club.goalsFor = club.getGoalsFor() + scoredGoalsWonTeam;
                club.goalsAgainst = club.getGoalsAgainst() + scoredGoalsLostTeam;
                club.goalsDifference = club.getGoalsDifference() + scoredGoalsWonTeam - scoredGoalsLostTeam;
                club.points = club.getPoints() + 3;
            }
        }
    }

    private void lostGame(int matchesPlayed, String lostTeam, int scoredGoalsLostTeam, int scoredGoalsWonTeam) {
        if (!lostTeam.isEmpty() && !lostTeam.isBlank()) {
            if (!leagueLeaderboards.containsKey(lostTeam)) {
                LeagueTable leagueTable = new LeagueTable.Builder()
                        .setClub(lostTeam)
                        .setMatchesPlayed(matchesPlayed)
                        .setGoalsFor(scoredGoalsLostTeam)
                        .setGoalsAgainst(scoredGoalsWonTeam)
                        .setGoalsDifference(scoredGoalsLostTeam - scoredGoalsWonTeam)
                        .setWon(0)
                        .setLost(1)
                        .setDrawn(0)
                        .setPoints(0)
                        .build();
                leagueLeaderboards.put(lostTeam, leagueTable);
            } else {
                LeagueTable club = leagueLeaderboards.get(lostTeam);
                club.matchesPlayed = matchesPlayed;
                club.lost = club.getLost() + 1;
                club.goalsFor = club.getGoalsFor() + scoredGoalsLostTeam;
                club.goalsAgainst = club.getGoalsAgainst() + scoredGoalsWonTeam;
                club.goalsDifference = club.getGoalsDifference() + scoredGoalsLostTeam - scoredGoalsWonTeam;
            }
        }
    }

    private void drawGame(int matchesPlayed, String homeTeam, String awayTeam, int scoredHomeTeam,
                          int scoredAwayTeam) {
        existingDrawGame(matchesPlayed, homeTeam, scoredHomeTeam, scoredAwayTeam);
        existingDrawGame(matchesPlayed, awayTeam, scoredAwayTeam, scoredHomeTeam);
    }

    private void existingDrawGame(int matchesPlayed, String team, int scoredHomeTeam,
                                  int scoredAwayTeam) {
        if (!team.isEmpty() && !team.isBlank()) {
            if (!leagueLeaderboards.containsKey(team)) {
                LeagueTable leagueTable = new LeagueTable.Builder()
                        .setClub(team)
                        .setMatchesPlayed(matchesPlayed)
                        .setGoalsFor(scoredHomeTeam)
                        .setGoalsAgainst(scoredAwayTeam)
                        .setGoalsDifference(scoredHomeTeam - scoredAwayTeam)
                        .setWon(0)
                        .setLost(0)
                        .setDrawn(1)
                        .setPoints(1)
                        .build();
                leagueLeaderboards.put(team, leagueTable);
            }
        } else {
            LeagueTable club = leagueLeaderboards.get(team);
            club.matchesPlayed = matchesPlayed;
            club.drawn = club.getDrawn() + 1;
            club.goalsFor = club.getGoalsFor() + scoredHomeTeam;
            club.goalsAgainst = club.getGoalsAgainst() + scoredAwayTeam;
            club.goalsDifference = club.getGoalsDifference() + scoredHomeTeam - scoredAwayTeam;
            club.points = club.getPoints() + 1;
        }
    }
}
