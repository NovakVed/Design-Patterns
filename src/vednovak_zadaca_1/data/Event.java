package vednovak_zadaca_1.data;

public class Event {
    //required
    private final int number;
    private final String minutes;
    private final String type;

    //optional
    private final String club;
    private final String player;
    private final String substitute;

    private Event(EventBuilder builder) {
        this.number = builder.number;
        this.minutes = builder.minutes;
        this.type = builder.type;
        this.club = builder.club;
        this.player = builder.player;
        this.substitute = builder.substitute;
    }

    public int getNumber() {
        return number;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getType() {
        return type;
    }

    public String getClub() {
        return club;
    }

    public String getPlayer() {
        return player;
    }

    public String getSubstitute() {
        return substitute;
    }

    @Override
    public String toString() {
        return "Broj: " + number + " Minute: " + minutes + " Tip: " + type
                + " Klub: " + club + " Igrac: " + player + " Zamjena: " + substitute;
    }

    public static class EventBuilder {
        //required
        private final int number;
        private final String minutes;
        private final String type;

        //optional
        private String club;
        private String player;
        private String substitute;

        public EventBuilder(int number, String minutes, String type) {
            this.number = number;
            this.minutes = minutes;
            this.type = type;
        }

        public EventBuilder setClub(String club) {
            this.club = club;
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
