package vednovak_zadaca_1.leaderboard;

public class LeagueLeadershipBuilder implements LeagueLeaderboard {
    private String club;
    private int matchesPlayed;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int goalsDifference;
    private int points;

    public void setClub(String club) {
        this.club = club;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public void setGoalsDifference(int goalsDifference) {
        this.goalsDifference = goalsDifference;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LeagueLeaderboardTemp getResult() {
        return new LeagueLeaderboardTemp(club, matchesPlayed, won, drawn, lost, goalsFor, goalsAgainst, goalsDifference, points);
    }
}
