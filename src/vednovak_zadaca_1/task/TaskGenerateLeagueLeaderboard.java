package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Club;
import vednovak_zadaca_1.data.Event;
import vednovak_zadaca_1.data.Game;
import vednovak_zadaca_1.leaderboard.LeagueLeaderboardDirector;
import vednovak_zadaca_1.leaderboard.LeagueLeaderboardTemp;
import vednovak_zadaca_1.leaderboard.LeagueLeadershipBuilder;

import java.util.*;

class TaskGenerateLeagueLeaderboard implements Task {
    private final int round;
    private final LeagueLeadershipBuilder builder = new LeagueLeadershipBuilder();
    public Map<String, LeagueLeaderboardTemp> leagueLeaderboards = new HashMap<>();

    TaskGenerateLeagueLeaderboard(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    TaskGenerateLeagueLeaderboard() {
        this.round = StoredData.games.get(StoredData.games.size() - 1).number;
        printTable();
    }

    public void printTable() {
        for (Game game : StoredData.games) {
            if (game.matchesPlayed <= round) {
                String teamWon = "";
                String teamLost = "";
                int scoredGoalsWonTeam = 0;
                int scoredGoalsLostTeam = 0;

                int scoredGoalsHomeTeam = 0;
                int scoredGoalsAwayTeam = 0;
                for (Event event : StoredData.events) {
                    if (game.number == event.getNumber()) {
                        if (event.getClub() != null) {
                            if (event.getClub().equals(game.home)) {
                                if (event.getType().equals("1")) scoredGoalsHomeTeam += 1;
                                if (event.getType().equals("2")) scoredGoalsHomeTeam += 1;
                                if (event.getType().equals("3")) scoredGoalsAwayTeam += 1;
                            }
                            if (event.getClub().equals(game.away)) {
                                if (event.getType().equals("1")) scoredGoalsAwayTeam += 1;
                                if (event.getType().equals("2")) scoredGoalsAwayTeam += 1;
                                if (event.getType().equals("3")) scoredGoalsHomeTeam += 1;
                            }
                        }
                    }
                }
                if (scoredGoalsHomeTeam > scoredGoalsAwayTeam) {
                    teamWon = game.home;
                    teamLost = game.away;
                    scoredGoalsWonTeam = scoredGoalsHomeTeam;
                    scoredGoalsLostTeam = scoredGoalsAwayTeam;
                }
                if (scoredGoalsAwayTeam > scoredGoalsHomeTeam) {
                    teamWon = game.away;
                    teamLost = game.home;
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
                    if (club.club.equals(game.home)) home = club.name;
                    if (club.club.equals(game.away)) away = club.name;
                }
                if (scoredGoalsHomeTeam == scoredGoalsAwayTeam) {
                    drawGame(game.matchesPlayed, home, away, scoredGoalsHomeTeam, scoredGoalsAwayTeam);
                }

                wonGame(game.matchesPlayed, teamWonFullName, scoredGoalsWonTeam, scoredGoalsLostTeam);
                lostGame(game.matchesPlayed, teamLostFullName, scoredGoalsLostTeam, scoredGoalsWonTeam);
            }
        }
        if (!leagueLeaderboards.isEmpty()) { //SORTIRANJE PO BODOVIMA!!
            Set<Map.Entry<String, LeagueLeaderboardTemp>> entrySet = leagueLeaderboards.entrySet();
            List<Map.Entry<String, LeagueLeaderboardTemp>> list = new ArrayList<>(entrySet);
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

    public void wonGame(int matchesPlayed, String wonTeam, int scoredGoalsWonTeam, int scoredGoalsLostTeam) {
        if (!wonTeam.isEmpty() && !wonTeam.isBlank()) {
            if (!leagueLeaderboards.containsKey(wonTeam)) {
                LeagueLeaderboardDirector director = new LeagueLeaderboardDirector(wonTeam,
                        matchesPlayed, scoredGoalsWonTeam, scoredGoalsLostTeam,
                        scoredGoalsWonTeam - scoredGoalsLostTeam);
                director.victory(this.builder);
                leagueLeaderboards.put(wonTeam, this.builder.getResult());
            } else {
                LeagueLeaderboardTemp club = leagueLeaderboards.get(wonTeam);
                club.setMatchesPlayed(matchesPlayed);
                club.setWon(club.getWon() + 1);
                club.setGoalsFor(club.getGoalsFor() + scoredGoalsWonTeam);
                club.setGoalsAgainst(club.getGoalsAgainst() + scoredGoalsLostTeam);
                club.setGoalsDifference(club.getGoalsDifference() + scoredGoalsWonTeam - scoredGoalsLostTeam);
                club.setPoints(club.getPoints() + 3);
                leagueLeaderboards.replace(wonTeam, club);
            }
        }
    }

    public void lostGame(int matchesPlayed, String lostTeam, int scoredGoalsLostTeam, int scoredGoalsWonTeam) {
        if (!lostTeam.isEmpty() && !lostTeam.isBlank()) {
            if (!leagueLeaderboards.containsKey(lostTeam)) {
                LeagueLeaderboardDirector director = new LeagueLeaderboardDirector(lostTeam,
                        matchesPlayed, scoredGoalsLostTeam, scoredGoalsWonTeam,
                        scoredGoalsLostTeam - scoredGoalsWonTeam);
                director.lost(this.builder);
                leagueLeaderboards.put(lostTeam, this.builder.getResult());
            } else {
                LeagueLeaderboardTemp club = leagueLeaderboards.get(lostTeam);
                club.setMatchesPlayed(matchesPlayed);
                club.setLost(club.getLost() + 1);
                club.setGoalsFor(club.getGoalsFor() + scoredGoalsLostTeam);
                club.setGoalsAgainst(club.getGoalsAgainst() + scoredGoalsWonTeam);
                club.setGoalsDifference(club.getGoalsDifference() + scoredGoalsLostTeam - scoredGoalsWonTeam);
                leagueLeaderboards.replace(lostTeam, club);
            }
        }
    }

    public void drawGame(int matchesPlayed, String homeTeam, String awayTeam, int scoredHomeTeam,
                         int scoredAwayTeam) {
        LeagueLeaderboardDirector directorHome = new LeagueLeaderboardDirector(homeTeam,
                matchesPlayed, scoredHomeTeam, scoredAwayTeam,
                scoredHomeTeam - scoredAwayTeam);
        LeagueLeaderboardDirector directorAway = new LeagueLeaderboardDirector(awayTeam,
                matchesPlayed, scoredAwayTeam, scoredHomeTeam,
                scoredAwayTeam - scoredHomeTeam);
        existingDrawGame(matchesPlayed, homeTeam, scoredHomeTeam, scoredAwayTeam, directorHome);
        existingDrawGame(matchesPlayed, awayTeam, scoredAwayTeam, scoredHomeTeam, directorAway);
    }

    private void existingDrawGame(int matchesPlayed, String team, int scoredHomeTeam,
                                  int scoredAwayTeam, LeagueLeaderboardDirector directorHome) {
        if (!team.isEmpty() && !team.isBlank()) {
            if (!leagueLeaderboards.containsKey(team)) {
                directorHome.draw(this.builder);
            }
        } else {
            LeagueLeaderboardTemp club = leagueLeaderboards.get(team);
            club.setMatchesPlayed(matchesPlayed);
            club.setDrawn(club.getDrawn() + 1);
            club.setGoalsFor(club.getGoalsFor() + scoredHomeTeam);
            club.setGoalsAgainst(club.getGoalsAgainst() + scoredAwayTeam);
            club.setGoalsDifference(club.getGoalsDifference() + scoredHomeTeam - scoredAwayTeam);
            club.setPoints(club.getPoints() + 1);
            leagueLeaderboards.replace(team, club);
        }
    }
}
