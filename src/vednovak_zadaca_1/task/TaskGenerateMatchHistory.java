package vednovak_zadaca_1.task;

import vednovak_zadaca_1.leaderboard.ScorerLeaderboard;

import java.util.HashMap;
import java.util.Map;

class TaskGenerateMatchHistory implements Task {
    private final String club;
    private final int round;
    public Map<String, ScorerLeaderboard> scorerLeaderboards = new HashMap<>();

    TaskGenerateMatchHistory(String club, String round) {
        this.club = club;
        this.round = Integer.parseInt(round);
    }

    public void printTable() {
    }
}
