package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Club;
import vednovak_zadaca_1.data.Event;
import vednovak_zadaca_1.data.Game;
import vednovak_zadaca_1.leaderboard.ScorerLeaderboard;

import java.util.*;

class TaskGenerateGoalLeaderboard implements Task {
    private final int round;
    public Map<String, ScorerLeaderboard> scorerLeaderboards = new HashMap<>();

    TaskGenerateGoalLeaderboard(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    TaskGenerateGoalLeaderboard() {
        this.round = StoredData.games.get(StoredData.games.size() - 1).number;
        printTable();
    }

    public void printTable() {
        for (Game game : StoredData.games) {
            if (game.matchesPlayed <= round) {
                int scoredGoals = 0;
                String playerName = "";
                String playerClub = "";

                for (Event event : StoredData.events) {
                    if (game.number == event.getNumber()) {
                        if (event.getClub() != null) {
                            if (event.getType().equals("1") || event.getType().equals("2")) {
                                scoredGoals += 1;
                                playerName = event.getPlayer();
                            }
                            System.out.println(playerName + " zabio je: " + scoredGoals);
                        }
                    }
                    for (Club club : StoredData.clubs) {
                        if (club.club.equals(event.getClub())) playerClub = club.name;
                    }
                    storeScorerLeaderboardList(playerName, playerClub, scoredGoals);
                    scoredGoals = 0;
                }
            }
        }
        if (!scorerLeaderboards.isEmpty()) { //SORTIRANJE PO BODOVIMA!!
            Set<Map.Entry<String, ScorerLeaderboard>> entrySet = scorerLeaderboards.entrySet();
            List<Map.Entry<String, ScorerLeaderboard>> list = new ArrayList<>(entrySet);
            Collections.sort(list, ((o1, o2) -> o2.getValue().getGoals() - o1.getValue().getGoals()));
            System.out.printf("%40s %40s %20s%n",
                    "Igrac", "Klub", "Golovi");

            list.forEach(k ->
                    System.out.printf("%40s %40s %20s%n",
                            k.getValue().getPlayerName(), k.getValue().getClubName(),
                            k.getValue().getGoals()));
        }
    }

    private void storeScorerLeaderboardList(String playerName, String playerClub, int scoredGoals) {
        ScorerLeaderboard scorerLeaderboard;
        if (!playerName.isEmpty() && !playerName.isBlank()
                && !playerClub.isEmpty() && !playerClub.isBlank()
                && scoredGoals != 0) {
            if (!scorerLeaderboards.containsKey(playerName)) {
                scorerLeaderboard = new ScorerLeaderboard(playerName, playerClub, scoredGoals);
                scorerLeaderboards.put(playerName, scorerLeaderboard);
            } else {
                scorerLeaderboard = scorerLeaderboards.get(playerName);
                scorerLeaderboard.setGoals(scorerLeaderboard.getGoals() + scoredGoals);
                scorerLeaderboards.replace(playerName, scorerLeaderboard);
            }
        }
    }
}
