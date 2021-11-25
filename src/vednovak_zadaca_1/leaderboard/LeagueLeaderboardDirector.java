package vednovak_zadaca_1.leaderboard;

public class LeagueLeaderboardDirector {
    private final String club;
    private final int matchesPlayed;
    private final int goalsFor;
    private final int goalsAgainst;
    private final int goalsDifference;

    public LeagueLeaderboardDirector(String club, int matchesPlayed, int goalsFor, int goalsAgainst, int goalsDifference) {
        this.club = club;
        this.matchesPlayed = matchesPlayed;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
    }

    public void victory(LeagueLeadershipBuilder builder) {
        builder.setClub(club);
        builder.setMatchesPlayed(matchesPlayed);
        builder.setWon(1);
        builder.setDrawn(0);
        builder.setLost(0);
        builder.setGoalsFor(goalsFor);
        builder.setGoalsAgainst(goalsAgainst);
        builder.setGoalsDifference(goalsDifference);
        builder.setPoints(3);
    }

    public void lost(LeagueLeadershipBuilder builder) {
        builder.setClub(club);
        builder.setMatchesPlayed(matchesPlayed);
        builder.setWon(0);
        builder.setDrawn(0);
        builder.setLost(1);
        builder.setGoalsFor(goalsFor);
        builder.setGoalsAgainst(goalsAgainst);
        builder.setGoalsDifference(goalsDifference);
        builder.setPoints(0);
    }

    public void draw(LeagueLeadershipBuilder builder) {
        builder.setClub(club);
        builder.setMatchesPlayed(matchesPlayed);
        builder.setWon(0);
        builder.setDrawn(1);
        builder.setLost(0);
        builder.setGoalsFor(goalsFor);
        builder.setGoalsAgainst(goalsAgainst);
        builder.setGoalsDifference(goalsDifference);
        builder.setPoints(1);
    }
}
