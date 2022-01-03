package vednovak_zadaca_3.data.club;

public abstract class Person extends ChampionshipMember {
    public String clubID;
    public String name;

    public Person(String clubID, String name) {
        this.clubID = clubID;
        this.name = name;
    }

    public String getPersonClubID() {
        return this.clubID;
    }

    public String getPersonName() {
        return this.name;
    }
}