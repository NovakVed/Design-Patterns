package vednovak_zadaca_1.data;

public class Club {
    public String club;
    public String name;
    public String coach;

    public Club(String club, String name, String coach) {
        this.club = club;
        this.name = name;
        this.coach = coach;
    }

    @Override
    public String toString(){
        return "Klub: " + club + " naziv: " + name + " trener: " + coach;
    }
}
