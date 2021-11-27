package vednovak_zadaca_1.table;

public class LeagueTable {
    public String club;
    public int matchesPlayed;
    public int won;
    public int drawn;
    public int lost;
    public int goalsFor;
    public int goalsAgainst;
    public int goalsDifference;
    public int points;

    public LeagueTable(Builder builder) {
        this.club = builder.club;
        this.matchesPlayed = builder.matchesPlayed;
        this.won = builder.won;
        this.drawn = builder.drawn;
        this.lost = builder.lost;
        this.goalsFor = builder.goalsFor;
        this.goalsAgainst = builder.goalsAgainst;
        this.goalsDifference = builder.goalsDifference;
        this.points = builder.points;
    }

    public String getClub() {
        return club;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getWon() {
        return won;
    }

    public int getDrawn() {
        return drawn;
    }

    public int getLost() {
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    public int getPoints() {
        return points;
    }

    public static class Builder {
        private String club;
        private int matchesPlayed;
        private int won;
        private int drawn;
        private int lost;
        private int goalsFor;
        private int goalsAgainst;
        private int goalsDifference;
        private int points;

        public Builder setClub(String club) {
            this.club = club;
            return this;
        }

        public Builder setMatchesPlayed(int matchesPlayed) {
            this.matchesPlayed = matchesPlayed;
            return this;
        }

        public Builder setWon(int won) {
            this.won = won;
            return this;
        }

        public Builder setDrawn(int drawn) {
            this.drawn = drawn;
            return this;
        }

        public Builder setLost(int lost) {
            this.lost = lost;
            return this;
        }

        public Builder setGoalsFor(int goalsFor) {
            this.goalsFor = goalsFor;
            return this;
        }

        public Builder setGoalsAgainst(int goalsAgainst) {
            this.goalsAgainst = goalsAgainst;
            return this;
        }

        public Builder setGoalsDifference(int goalsDifference) {
            this.goalsDifference = goalsDifference;
            return this;
        }

        public Builder setPoints(int points) {
            this.points = points;
            return this;
        }

        public LeagueTable build() {
            return new LeagueTable(this);
        }
    }
}
