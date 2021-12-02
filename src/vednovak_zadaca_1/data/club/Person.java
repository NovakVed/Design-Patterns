package vednovak_zadaca_1.data.club;

public abstract class Person implements Member {
    public String clubID;
    public String name;

    public Person(String clubID, String name) {
        this.clubID = clubID;
        this.name = name;
    }
}