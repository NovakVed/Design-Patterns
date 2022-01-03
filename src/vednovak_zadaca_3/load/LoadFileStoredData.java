package vednovak_zadaca_3.load;

import vednovak_zadaca_3.data.championship.Event;
import vednovak_zadaca_3.data.championship.GameLineup;
import vednovak_zadaca_3.data.championship.Match;
import vednovak_zadaca_3.data.club.Club;
import vednovak_zadaca_3.data.club.Player;

import java.util.ArrayList;
import java.util.List;

class LoadFileStoredData {
    static List<Club> clubs = new ArrayList<>();
    static List<Match> matches = new ArrayList<>();
    static List<GameLineup> gameLineups = new ArrayList<>();
    static List<Player> players = new ArrayList<>();
    static List<Event> events = new ArrayList<>();

    private static volatile LoadFileStoredData INSTANCE;

    public LoadFileStoredData() {
    }

    public static LoadFileStoredData getInstance() {
        if (INSTANCE == null)
            synchronized (LoadFileStoredData.class) {
                if (INSTANCE == null)
                    INSTANCE = new LoadFileStoredData();
            }
        return INSTANCE;
    }
}
