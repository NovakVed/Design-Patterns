package vednovak_zadaca_1.table;

public class MatchHistory {
    public int round;
    public String date;
    public String homeTeam;
    public String awayTeam;
    public String gameScore;

    public MatchHistory(Builder builder) {
        this.round = builder.round;
        this.date = builder.date;
        this.homeTeam = builder.homeTeam;
        this.awayTeam = builder.awayTeam;
        this.gameScore = builder.gameScore;
    }

    public int getRound() {
        return round;
    }

    public String getDate() {
        return date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getGameScore() {
        return gameScore;
    }

    public static class Builder {
        private int round;
        private String date;
        private String homeTeam;
        private String awayTeam;
        private String gameScore;

        public Builder setRound(int round) {
            this.round = round;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setHomeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
            return this;
        }

        public Builder setAwayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
            return this;
        }

        public Builder setGameScore(String gameScore) {
            this.gameScore = gameScore;
            return this;
        }

        public MatchHistory build() {
            return new MatchHistory(this);
        }
    }
}
