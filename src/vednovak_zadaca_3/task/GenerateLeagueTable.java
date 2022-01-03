package vednovak_zadaca_3.task;

import vednovak_zadaca_3.StoredData;
import vednovak_zadaca_3.data.championship.Match;
import vednovak_zadaca_3.data.championship.MatchDetails;
import vednovak_zadaca_3.data.club.Club;
import vednovak_zadaca_3.table.LeagueTable;

import java.util.HashMap;
import java.util.Map;

class GenerateLeagueTable implements Table {
    private final int round;
    public Map<String, LeagueTable> leagueLeaderboards = new HashMap<>();

    GenerateLeagueTable() {
        this.round = StoredData.matches.size();
        printTable();
    }

    GenerateLeagueTable(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    public void printTable() {
        for (Match match : StoredData.matches.values()) {
            if (match.round <= round) {
                String teamWon = "";
                String teamLost = "";
                int scoredGoalsWonTeam = 0;
                int scoredGoalsLostTeam = 0;

                int scoredGoalsHomeTeam = 0;
                int scoredGoalsAwayTeam = 0;
                for (MatchDetails matchDetails : match.matchEvents) {
                    if (matchDetails.getClubID() != null) {
                        if (matchDetails.getClubID().equals(match.homeTeam)) {
                            if (matchDetails.getType().equals("1")) scoredGoalsHomeTeam += 1;
                            if (matchDetails.getType().equals("2")) scoredGoalsHomeTeam += 1;
                            if (matchDetails.getType().equals("3")) scoredGoalsAwayTeam += 1;
                        }
                        if (matchDetails.getClubID().equals(match.awayTeam)) {
                            if (matchDetails.getType().equals("1")) scoredGoalsAwayTeam += 1;
                            if (matchDetails.getType().equals("2")) scoredGoalsAwayTeam += 1;
                            if (matchDetails.getType().equals("3")) scoredGoalsHomeTeam += 1;
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
                String teamWonCoachName = "";
                String teamLostFullName = "";
                String teamLostCoachName = "";
                String home = "";
                String homeCoach = "";
                String away = "";
                String awayCoach = "";
                for (Club club : StoredData.clubs.values()) {
                    if (club.clubID.equals(teamWon)) {
                        teamWonFullName = club.name;
                        teamWonCoachName = club.coach;
                    }
                    if (club.clubID.equals(teamLost)) {
                        teamLostFullName = club.name;
                        teamLostCoachName = club.coach;
                    }
                    if (club.clubID.equals(match.homeTeam)) {
                        home = club.name;
                        homeCoach = club.coach;
                    }
                    if (club.clubID.equals(match.awayTeam)) {
                        away = club.name;
                        awayCoach = club.coach;
                    }
                }
                if (scoredGoalsHomeTeam == scoredGoalsAwayTeam) {
                    drawGame(match.round, home, homeCoach, away, awayCoach, scoredGoalsHomeTeam, scoredGoalsAwayTeam);
                }

                wonGame(match.round, teamWonFullName, teamWonCoachName, scoredGoalsWonTeam, scoredGoalsLostTeam);
                lostGame(match.round, teamLostFullName, teamLostCoachName, scoredGoalsLostTeam, scoredGoalsWonTeam);
            }
        }
    }

    private void wonGame(int matchesPlayed, String wonTeam, String coach, int scoredGoalsWonTeam, int scoredGoalsLostTeam) {
        if (!wonTeam.isEmpty() && !wonTeam.isBlank()) {
            if (!leagueLeaderboards.containsKey(wonTeam)) {
                LeagueTable leagueTable = new LeagueTable.Builder()
                        .setClub(wonTeam)
                        .setCoach(coach)
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

    private void lostGame(int matchesPlayed, String lostTeam, String coach, int scoredGoalsLostTeam, int scoredGoalsWonTeam) {
        if (!lostTeam.isEmpty() && !lostTeam.isBlank()) {
            if (!leagueLeaderboards.containsKey(lostTeam)) {
                LeagueTable leagueTable = new LeagueTable.Builder()
                        .setClub(lostTeam)
                        .setCoach(coach)
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

    private void drawGame(int matchesPlayed, String homeTeam, String homeCoach, String awayTeam,
                          String awayCoach, int scoredHomeTeam, int scoredAwayTeam) {
        existingDrawGame(matchesPlayed, homeTeam, homeCoach, scoredHomeTeam, scoredAwayTeam);
        existingDrawGame(matchesPlayed, awayTeam, awayCoach, scoredAwayTeam, scoredHomeTeam);
    }

    private void existingDrawGame(int matchesPlayed, String team, String coach, int scoredHomeTeam,
                                  int scoredAwayTeam) {
        if (!team.isEmpty() && !team.isBlank()) {
            if (!leagueLeaderboards.containsKey(team)) {
                LeagueTable leagueTable = new LeagueTable.Builder()
                        .setClub(team)
                        .setCoach(coach)
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

    @Override
    public void accept(TableVisitor tableVisitor) {
        tableVisitor.visit(this);
    }
}
