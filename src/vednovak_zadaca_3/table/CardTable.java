package vednovak_zadaca_3.table;

public class CardTable {
    public String clubName;
    public int firstYellowCards;
    public int secondYellowCards;
    public int redCards;
    public int allCards;

    private CardTable(Builder builder) {
        this.clubName = builder.clubName;
        this.firstYellowCards = builder.firstYellowCards;
        this.secondYellowCards = builder.secondYellowCards;
        this.redCards = builder.redCards;
        this.allCards = builder.allCards;
    }

    public String getClubName() {
        return clubName;
    }

    public int getFirstYellowCards() {
        return firstYellowCards;
    }

    public int getSecondYellowCards() {
        return secondYellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getAllCards() {
        return allCards;
    }

    public static class Builder {
        private String clubName;
        private int firstYellowCards;
        private int secondYellowCards;
        private int redCards;
        private int allCards;


        public Builder setClubName(String clubName) {
            this.clubName = clubName;
            return this;
        }

        public Builder setFirstYellowCards(int firstYellowCards) {
            this.firstYellowCards = firstYellowCards;
            return this;
        }

        public Builder setSecondYellowCards(int secondYellowCards) {
            this.secondYellowCards = secondYellowCards;
            return this;
        }

        public Builder setRedCards(int redCards) {
            this.redCards = redCards;
            return this;
        }

        public Builder setAllCards(int allCards) {
            this.allCards = allCards;
            return this;
        }

        public CardTable build() {
            return new CardTable(this);
        }
    }
}
