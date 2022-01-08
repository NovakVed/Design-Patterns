package vednovak_zadaca_3;

import vednovak_zadaca_3.data.championship.Event;
import vednovak_zadaca_3.data.championship.GameLineup;
import vednovak_zadaca_3.data.championship.Match;
import vednovak_zadaca_3.data.club.Club;
import vednovak_zadaca_3.data.club.Coach;
import vednovak_zadaca_3.data.club.Player;
import vednovak_zadaca_3.load.LoadFileFacade;

import java.util.List;

public class LoadDirector {
    public void loadData(String dataType, String fileName) {
        if (dataType == null || dataType.isEmpty()) System.out.println("ERROR: ne postoji klasa");
        if (dataType != null && dataType.matches("-[kiusd]")) {
            LoadFileFacade loadFileFacade = new LoadFileFacade();
            if (dataType.equals("-k")) {
                storeClubDataToClubComposite(loadFileFacade.loadClubData(fileName));
            }
            if (dataType.equals("-i")) {
                storePlayerDataToClubComposite(loadFileFacade.loadPlayerData(fileName));
            }
            if (dataType.equals("-u")) {
                storeMatchDataToMatchComposite(loadFileFacade.loadMatchData(fileName));
            }
            if (dataType.equals("-s")) {
                storeGameLineupsDataToMatchComposite(loadFileFacade.loadGameLineupData(fileName));
            }
            if (dataType.equals("-d")) {
                storeEventDataToMatchComposite(loadFileFacade.loadEventData(fileName));
            }
        } else System.out.println("ERROR: nepravilno uneseni argumenti");
    }

    public void storeClubDataToClubComposite(List<Club> clubs) {
        for (Club club : clubs) {
            club.add(new Coach(club.clubID, club.coach));
            StoredData.clubs.put(club.clubID, club);
        }
    }

    public void storePlayerDataToClubComposite(List<Player> players) {
        for (Player player : players) {
            if (StoredData.clubs.containsKey(player.clubID)) {
                StoredData.clubs.get(player.clubID).add(player);
            }
        }
    }

    public void storeMatchDataToMatchComposite(List<Match> matches) {
        for (Match match : matches) {
            StoredData.matches.put(match.matchID, match);
        }
    }

    public void storeGameLineupsDataToMatchComposite(List<GameLineup> gameLineups) {
        for (GameLineup gameLineup : gameLineups) {
            if (StoredData.matches.containsKey(gameLineup.matchID)) {
                StoredData.matches.get(gameLineup.matchID).addGameLineups(gameLineup);
            }
        }
    }

    public void storeEventDataToMatchComposite(List<Event> events) {
        for (Event event : events) {
            if (StoredData.matches.containsKey(event.getMatchID())) {
                StoredData.matches.get(event.getMatchID()).addEvents(event);
            }
        }
    }
}