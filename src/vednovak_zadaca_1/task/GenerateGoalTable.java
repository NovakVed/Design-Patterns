package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Club;
import vednovak_zadaca_1.data.Event;
import vednovak_zadaca_1.data.Match;
import vednovak_zadaca_1.table.ScorerTable;

import java.util.*;

class GenerateGoalTable implements Task {
    private final int round;
    public Map<String, ScorerTable> scorerLeaderboards = new HashMap<>();

    GenerateGoalTable() {
        this.round = StoredData.matches.get(StoredData.matches.size() - 1).matchID;
        printTable();
    }

    GenerateGoalTable(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    public void printTable() {
        for (Match match : StoredData.matches) {
            if (match.round <= round) {
                int scoredGoals = 0;
                String playerName = "";
                String playerClub = "";

                for (Event event : StoredData.events) {
                    if (match.matchID == event.getMatchID()) {
                        if (event.getClub() != null) {
                            if (event.getType().equals("1") || event.getType().equals("2")) {
                                scoredGoals += 1;
                                playerName = event.getPlayer();
                            }
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
            Set<Map.Entry<String, ScorerTable>> entrySet = scorerLeaderboards.entrySet();
            List<Map.Entry<String, ScorerTable>> list = new ArrayList<>(entrySet);
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
        ScorerTable scorerTable;
        if (!playerName.isEmpty() && !playerName.isBlank()
                && !playerClub.isEmpty() && !playerClub.isBlank()
                && scoredGoals != 0) {
            if (!scorerLeaderboards.containsKey(playerName)) {
                scorerTable = new ScorerTable.Builder(playerName, playerClub, scoredGoals).build();
                scorerLeaderboards.put(playerName, scorerTable);
            } else {
                scorerTable = scorerLeaderboards.get(playerName);
                scorerTable.goals = scorerTable.getGoals() + scoredGoals;
            }
        }
    }
}
