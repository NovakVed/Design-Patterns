package vednovak_zadaca_3.task;

import vednovak_zadaca_3.data.championship.MatchDetails;
import vednovak_zadaca_3.data.club.Player;
import vednovak_zadaca_3.data.club.position.PlayerPosition;
import vednovak_zadaca_3.data.club.state.PlayerRemovedFromGame;
import vednovak_zadaca_3.data.club.state.PlayerSubstitute;

import java.util.ArrayList;

public class GenerateGamePlan {
    MatchDetails matchDetails;
    ArrayList<Player> homeLineup = new ArrayList<>();
    ArrayList<Player> awayLineup = new ArrayList<>();

    public GenerateGamePlan(MatchDetails matchDetails) {
        this.matchDetails = matchDetails;
        loadGameLineup();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Početak utakmice");
        System.out.println("---------------------------------------------------------------------");
        generateGameLineup();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Kraj utakmice");
        System.out.println("---------------------------------------------------------------------");
        generateEndGameLineup();
    }

    public void loadGameLineup() {
        String homeTeam = matchDetails.getHomeTeam();
        String awayTeam = matchDetails.getAwayTeam();

        for (MatchDetails gameLineup : matchDetails.getMatchGamePlan()) {
            if (gameLineup.getClubID().equals(homeTeam))
                homeLineup.add(gameLineup.getPlayer());
            if (gameLineup.getClubID().equals(awayTeam))
                awayLineup.add(gameLineup.getPlayer());
        }
    }

    public void generateGameLineup() {
        for (PlayerPosition playerPosition : PlayerPosition.values()) {
            for (Player player : homeLineup) {
                if (player.getState().toString().equals("S"))
                    if (player.getPosition().contains(playerPosition.toString())) {
                        System.out.printf("%s:%s%n",
                                player.getPosition(), player.name);
                    }
            }
            for (Player player : awayLineup) {
                if (player.getState().toString().equals("S"))
                    if (player.getPosition().contains(playerPosition.toString())) {
                        System.out.printf("%40s:%s%n",
                                player.getPosition(), player.name);
                    }
            }
        }
    }

    public void generateEndGameLineup() {
        generateEvents();
        generateGameLineup();
    }

    public void generateEvents() {
        for (MatchDetails matchDetailsEvents : matchDetails.getMatchEvents()) {
            if (matchDetailsEvents.getType().equals("11")) {
                PlayerRemovedFromGame playerRemovedFromGame = new PlayerRemovedFromGame();
                playerRemovedFromGame.doAction(matchDetailsEvents.getPlayer());
            }
            if (matchDetailsEvents.getType().equals("20")) {
                PlayerSubstitute playerSubstitute = new PlayerSubstitute();
                playerSubstitute.doAction(matchDetailsEvents.getPlayer());
                playerSubstitute.doAction(matchDetailsEvents.getSubstitute());
            }
        }
    }
}
