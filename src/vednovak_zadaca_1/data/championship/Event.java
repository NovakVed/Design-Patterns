package vednovak_zadaca_1.data.championship;

public class Event implements MatchDetails {
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
        this.minutes = builder.minutes;
        this.type = builder.type;
        this.clubID = builder.clubID;
        this.player = builder.player;
        this.substitute = builder.substitute;
    }

    public int getMatchID() {
        return matchID;
    }

    public String getMinutes() {
        return minutes;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getClubID() {
        return clubID;
    }

    @Override
    public String getPlayer() {
        return player;
    }

    public String getSubstitute() {
        return substitute;
    }

    @Override
    public String toString() {
        return "utakmicaID: " + matchID + " Minute: " + minutes + " Tip: " + type
                + " Klub: " + clubID + " Igrac: " + player + " Zamjena: " + substitute;
    }

    @Override
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
