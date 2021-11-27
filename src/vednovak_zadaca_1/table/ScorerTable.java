package vednovak_zadaca_1.table;

public class ScorerTable {
    public String playerName;
    public String clubName;
    public int goals;

    public ScorerTable(Builder builder) {
        this.playerName = builder.playerName;
        this.clubName = builder.clubName;
        this.goals = builder.goals;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getClubName() {
        return clubName;
    }

    public int getGoals() {
        return goals;
    }

    public static class Builder {
        private String playerName;
        private String clubName;
        private int goals;

        public Builder(String playerName, String clubName, int goals) {
            this.playerName = playerName;
            this.clubName = clubName;
            this.goals = goals;
        }
        public Builder setPlayerName(String playerName) {
            this.playerName = playerName;
            return this;
        }
        public Builder setClubName(String clubName) {
            this.clubName = clubName;
            return this;
        }
        public Builder setGoals(int goals) {
            this.goals = goals;
            return this;
        }
        public ScorerTable build() {
            return new ScorerTable(this);
        }
    }
}
