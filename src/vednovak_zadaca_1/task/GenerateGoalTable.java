package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.championship.Match;
import vednovak_zadaca_1.data.championship.MatchDetails;
import vednovak_zadaca_1.data.club.Club;
import vednovak_zadaca_1.load.StoredFileObjects;
import vednovak_zadaca_1.table.ScorerTable;

import java.util.HashMap;
import java.util.Map;

class GenerateGoalTable implements Table {
    private final int round;
    public Map<String, ScorerTable> scorerLeaderboards = new HashMap<>();

    GenerateGoalTable() {
        this.round = StoredData.matches.size();
        printTable();
    }

    GenerateGoalTable(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    public void printTable() {
        for (Match match : StoredData.matches.values()) {
            if (match.round <= round) {
                int scoredGoals = 0;
                String playerName = "";
                String playerClub = "";

                for (MatchDetails matchDetails : match.matchEvents) {
                    if (matchDetails.getClubID() != null) {
                        if (matchDetails.getType().equals("1") || matchDetails.getType().equals("2")) {
                            scoredGoals += 1;
                            playerName = matchDetails.getPlayer();
                        }
                    }
                    for (Club club : StoredFileObjects.clubs) {
                        if (club.clubID.equals(matchDetails.getClubID())) playerClub = club.name;
                    }
                    storeScorerLeaderboardList(playerName, playerClub, scoredGoals);
                    scoredGoals = 0;
                }
            }
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

    @Override
    public void accept(TableVisitor tableVisitor) {
        tableVisitor.visit(this);
    }
}
