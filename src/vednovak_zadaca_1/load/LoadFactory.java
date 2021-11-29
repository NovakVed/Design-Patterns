package vednovak_zadaca_1.load;

public class LoadFactory {
    public void loadData(String dataType, String fileName) {
        if (dataType == null || dataType.isEmpty()) return;
        switch (dataType) {
            case "-k":
                new LoadClub(fileName);
            case "-i":
                new LoadPlayer(fileName);
            case "-u":
                new LoadMatch(fileName);
            case "-s":
                new LoadGameLineup(fileName);
            case "-d":
                new LoadEvent(fileName);
            default:
                System.out.println("ERROR: Unesena zastavica ne postoji!");
        }
    }
}
