package vednovak_zadaca_1;

import vednovak_zadaca_1.data.championship.Event;
import vednovak_zadaca_1.data.championship.GameLineup;
import vednovak_zadaca_1.data.championship.Match;
import vednovak_zadaca_1.data.club.Club;
import vednovak_zadaca_1.data.club.Coach;
import vednovak_zadaca_1.data.club.Member;
import vednovak_zadaca_1.data.club.Player;

import java.util.List;

public class LoadFactory {
    public void loadData(String dataType, String fileName) {
        if (dataType == null || dataType.isEmpty()) return;
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
    }

    public void storeClubDataToClubComposite(List<Club> clubs) {
        for (Club club : clubs) {
            Member member = new Coach(club.clubID, club.coach);
            club.add(member);
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
                StoredData.matches.get(gameLineup.matchID).addMatchGameLineups(gameLineup);
            }
        }
    }

    public void storeEventDataToMatchComposite(List<Event> events) {
        for (Event event : events) {
            if (StoredData.matches.containsKey(event.getMatchID())) {
                StoredData.matches.get(event.getMatchID()).addMatchEvents(event);
            }
        }
    }
}