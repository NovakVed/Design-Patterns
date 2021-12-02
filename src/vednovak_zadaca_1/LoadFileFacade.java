package vednovak_zadaca_1;

import vednovak_zadaca_1.data.championship.Event;
import vednovak_zadaca_1.data.championship.GameLineup;
import vednovak_zadaca_1.data.championship.Match;
import vednovak_zadaca_1.data.club.Club;
import vednovak_zadaca_1.data.club.Player;
import vednovak_zadaca_1.load.*;

import java.util.List;

public class LoadFileFacade {
    private final LoadClub loadClub;
    private final LoadEvent loadEvent;
    private final LoadGameLineup loadGameLineup;
    private final LoadMatch loadMatch;
    private final LoadPlayer loadPlayer;

    public LoadFileFacade() {
        this.loadClub = new LoadClub();
        this.loadEvent = new LoadEvent();
        this.loadGameLineup = new LoadGameLineup();
        this.loadMatch = new LoadMatch();
        this.loadPlayer = new LoadPlayer();
        StoredFileObjects.getInstance();
    }

    public List<Club> loadClubData(String fileName) {
        loadClub.readFileData(fileName);
        if (StoredFileObjects.clubs.isEmpty()) return null;
        return StoredFileObjects.clubs;
    }

    public List<Event> loadEventData(String fileName) {
        loadEvent.readFileData(fileName);
        if (StoredFileObjects.events.isEmpty()) return null;
        return StoredFileObjects.events;
    }

    public List<GameLineup> loadGameLineupData(String fileName) {
        loadGameLineup.readFileData(fileName);
        if (StoredFileObjects.gameLineups.isEmpty()) return null;
        return StoredFileObjects.gameLineups;
    }

    public List<Match> loadMatchData(String fileName) {
        loadMatch.readFileData(fileName);
        if (StoredFileObjects.matches.isEmpty()) return null;
        return StoredFileObjects.matches;
    }

    public List<Player> loadPlayerData(String fileName) {
        loadPlayer.readFileData(fileName);
        if (StoredFileObjects.players.isEmpty()) return null;
        return StoredFileObjects.players;
    }
}
