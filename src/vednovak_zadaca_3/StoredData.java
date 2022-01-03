package vednovak_zadaca_3;

import vednovak_zadaca_3.data.championship.Match;
import vednovak_zadaca_3.data.club.Club;

import java.util.HashMap;
import java.util.Map;

public class StoredData {
    public static Map<String, Club> clubs = new HashMap<>();
    public static Map<Integer, Match> matches = new HashMap<>();

    private static volatile StoredData INSTANCE;

    public StoredData() {
    }

    public static StoredData getInstance() {
        if (INSTANCE == null) synchronized (StoredData.class) {
            if (INSTANCE == null) INSTANCE = new StoredData();
        }
        return INSTANCE;
    }
}
