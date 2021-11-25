package vednovak_zadaca_1;

import vednovak_zadaca_1.data.*;

import java.util.ArrayList;
import java.util.List;

public class StoredData {
    public static List<Club> clubs = new ArrayList<>();
    public static List<Game> games = new ArrayList<>();
    public static List<GameLineup> gameLineups = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();

    private static volatile StoredData INSTANCE;

    public static StoredData getInstance() {
        if (INSTANCE == null)
            synchronized (StoredData.class) {
                if (INSTANCE == null)
                    INSTANCE = new StoredData();
            }
        return INSTANCE;
    }
}
