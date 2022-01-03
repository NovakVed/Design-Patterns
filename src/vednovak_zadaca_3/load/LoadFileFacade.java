package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.championship.Event;
import vednovak_zadaca_1.data.championship.GameLineup;
import vednovak_zadaca_1.data.championship.Match;
import vednovak_zadaca_1.data.club.Club;
import vednovak_zadaca_1.data.club.Player;

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
        LoadFileStoredData.getInstance();
    }

    public List<Club> loadClubData(String fileName) {
        loadClub.readFileData(fileName);
        if (LoadFileStoredData.clubs.isEmpty()) return null;
        return LoadFileStoredData.clubs;
    }

    public List<Event> loadEventData(String fileName) {
        loadEvent.readFileData(fileName);
        if (LoadFileStoredData.events.isEmpty()) return null;
        return LoadFileStoredData.events;
    }

    public List<GameLineup> loadGameLineupData(String fileName) {
        loadGameLineup.readFileData(fileName);
        if (LoadFileStoredData.gameLineups.isEmpty()) return null;
        return LoadFileStoredData.gameLineups;
    }

    public List<Match> loadMatchData(String fileName) {
        loadMatch.readFileData(fileName);
        if (LoadFileStoredData.matches.isEmpty()) return null;
        return LoadFileStoredData.matches;
    }

    public List<Player> loadPlayerData(String fileName) {
        loadPlayer.readFileData(fileName);
        if (LoadFileStoredData.players.isEmpty()) return null;
        return LoadFileStoredData.players;
    }
}
