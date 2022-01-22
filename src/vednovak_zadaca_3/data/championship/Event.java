package vednovak_zadaca_3.data.championship;

import vednovak_zadaca_3.StoredData;
import vednovak_zadaca_3.data.club.ChampionshipMember;
import vednovak_zadaca_3.data.club.Club;
import vednovak_zadaca_3.data.club.Player;

public class Event extends MatchDetails {
    //required
    private final int matchID;
    private final String minutes;
    private final String type;

    //optional
    private final String clubID;
    private final String player;
    private final String substitute;

    private Event(EventBuilder builder) {
        this.matchID = builder.matchID;
        this.clubID = builder.clubID;
        this.type = builder.type;
        this.player = builder.player;
        this.minutes = builder.minutes;
        this.substitute = builder.substitute;
    }

    public int getMatchID() {
        return matchID;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getType() {
        return type;
    }

    public String getClubID() {
        return clubID;
    }

    public String getPlayerName() {
        return player;
    }

    public Player getPlayer() {
        for (Club club : StoredData.clubs.values()) {
            for (ChampionshipMember member : club.championshipMembers) {
                if (member.getPersonName().equals(this.player)) return member.getPlayer();
            }
        }
        return null;
    }

    public String getSubstituteName() {
        return substitute;
    }

    public Player getSubstitute() {
        for (Club club : StoredData.clubs.values()) {
            for (ChampionshipMember member : club.championshipMembers) {
                if (member.getPersonName().equals(this.substitute)) return member.getPlayer();
            }
        }
        return null;
    }

    public String getTeamFullName() {
        for (Club club : StoredData.clubs.values()) {
            if (club.clubID.equals(getClubID())) return club.getClubName();
        }
        return "";
    }

    @Override
    public String toString() {
        return "utakmicaID: " + matchID + " Minute: " + minutes + " Tip: " + type
                + " Klub: " + clubID + " Igrac: " + player + " Zamjena: " + substitute;
    }

    public void showMatchDetails() {
        System.out.println(this);
    }

    public static class EventBuilder {
        //required
        private final int matchID;
        private final String minutes;
        private final String type;

        //optional
        private String clubID;
        private String player;
        private String substitute;

        public EventBuilder(int matchID, String minutes, String type) {
            this.matchID = matchID;
            this.minutes = minutes;
            this.type = type;
        }

        public EventBuilder setClubID(String clubID) {
            this.clubID = clubID;
            return this;
        }

        public EventBuilder setPlayer(String player) {
            this.player = player;
            return this;
        }

        public EventBuilder setSubstitute(String substitute) {
            this.substitute = substitute;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}
