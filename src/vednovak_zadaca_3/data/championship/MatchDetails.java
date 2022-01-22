package vednovak_zadaca_3.data.championship;

import vednovak_zadaca_3.data.club.ChampionshipMember;
import vednovak_zadaca_3.data.club.Player;

import java.util.List;

public abstract class MatchDetails {
    public void add(ChampionshipMember member) {
        throw new UnsupportedOperationException();
    }

    public List<MatchDetails> getMatchDetails() {
        throw new UnsupportedOperationException();
    }

    public List<MatchDetails> getMatchEvents() {
        throw new UnsupportedOperationException();
    }

    public List<MatchDetails> getMatchGamePlan() {
        throw new UnsupportedOperationException();
    }

    public void showMatchDetails() {
        throw new UnsupportedOperationException();
    }

    public int getMatchID() {
        throw new UnsupportedOperationException();
    }

    public int getRound() {
        throw new UnsupportedOperationException();
    }

    public String getHomeTeam() {
        throw new UnsupportedOperationException();
    }

    public String getAwayTeam() {
        throw new UnsupportedOperationException();
    }

    public String getTeamFullName() {
        throw new UnsupportedOperationException();
    }

    public String getMatchStart() {
        throw new UnsupportedOperationException();
    }

    public String getType() {
        throw new UnsupportedOperationException();
    }

    public String getClubID() {
        throw new UnsupportedOperationException();
    }

    public String getPlayerName() {
        throw new UnsupportedOperationException();
    }

    public Player getPlayer() {
        throw new UnsupportedOperationException();
    }

    public String getPlayerPosition() {
        throw new UnsupportedOperationException();
    }

    public String getMinutes() {
        throw new UnsupportedOperationException();
    }

    public String getSubstituteName() {
        throw new UnsupportedOperationException();
    }

    public Player getSubstitute() {
        throw new UnsupportedOperationException();
    }
}