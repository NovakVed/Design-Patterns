package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.championship.Event;
import vednovak_zadaca_1.data.championship.GameLineup;
import vednovak_zadaca_1.data.championship.Match;
import vednovak_zadaca_1.data.club.Club;
import vednovak_zadaca_1.data.club.Player;

import java.util.ArrayList;
import java.util.List;

public class StoredFileObjects {
    public static List<Club> clubs = new ArrayList<>();
    public static List<Match> matches = new ArrayList<>();
    public static List<GameLineup> gameLineups = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();
    public static List<Event> events = new ArrayList<>();

    private static volatile StoredFileObjects INSTANCE;

    public StoredFileObjects() {}

    public static StoredFileObjects getInstance() {
        if (INSTANCE == null)
            synchronized (StoredFileObjects.class) {
                if (INSTANCE == null)
                    INSTANCE = new StoredFileObjects();
            }
        return INSTANCE;
    }
}
