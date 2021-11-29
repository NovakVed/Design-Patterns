package vednovak_zadaca_1.load;

public class LoadFactory {
    public LoadData loadData(String[] args) {
        if (args[0] == null || args[0].isEmpty()) return null;
        if (args[0].equals("-k")) {
            return new LoadClub(args[1]);
        }
        if (args[0].equals("-i")) {
            return new LoadPlayer(args[1]);
        }
        if (args[0].equals("-u")) {
            return new LoadMatch(args[1]);
        }
        if (args[0].equals("-s")) {
            return new LoadGameLineup(args[1]);
        }
        if (args[0].equals("-d")) {
            return new LoadEvent(args[1]);
        }
        System.out.println("ERROR: Unesena zastavica ne postoji!");
        return null;
    }
}
