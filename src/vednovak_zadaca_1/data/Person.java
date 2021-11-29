package vednovak_zadaca_1.data;

public abstract class Person {
    public String club;
    public String name;
    public String born;

    public Person(String club, String name, String born) {
        this.club = club;
        this.name = name;
        this.born = born;
    }
}
