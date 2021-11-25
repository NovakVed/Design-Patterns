package vednovak_zadaca_1.leaderboard;

public interface LeagueLeaderboard {
    void setClub(String club);

    void setMatchesPlayed(int matchesPlayed);

    void setWon(int won);

    void setDrawn(int drawn);

    void setLost(int lost);

    void setGoalsFor(int goalsFor);

    void setGoalsAgainst(int goalsAgainst);

    void setGoalsDifference(int goalsDifference);

    void setPoints(int points);
}
