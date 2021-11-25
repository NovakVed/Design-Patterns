package vednovak_zadaca_1.leaderboard;

public class ScorerLeaderboard {
    public String playerName;
    public String clubName;
    public int goals;

    public ScorerLeaderboard(String playerName, String clubName, int goals) {
        this.playerName = playerName;
        this.clubName = clubName;
        this.goals = goals;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
