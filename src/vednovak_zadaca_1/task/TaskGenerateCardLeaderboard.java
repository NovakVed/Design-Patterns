package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Club;
import vednovak_zadaca_1.data.Event;
import vednovak_zadaca_1.data.Game;
import vednovak_zadaca_1.leaderboard.CardLeaderboard;

import java.util.*;

public class TaskGenerateCardLeaderboard implements Task {
    private final int round;
    public Map<String, CardLeaderboard> cardLeaderboards = new HashMap<>();
    public Map<String, Integer> doubleYellows = new HashMap<>();

    TaskGenerateCardLeaderboard(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    TaskGenerateCardLeaderboard() {
        this.round = StoredData.games.get(StoredData.games.size() - 1).number;
        printTable();
    }

    public void printTable() {
        for (Game game : StoredData.games) {
            if (game.matchesPlayed <= round) {
                String clubName = "";
                int firstYellowCards = 0;
                int secondYellowCards = 0;
                int redCards = 0;

                for (Event event : StoredData.events) {
                    if (game.number == event.getNumber()) {
                        if (event.getClub() != null) {
                            if (event.getType().equals("10")) {
                                if (doubleYellows.containsKey(event.getPlayer()))
                                    secondYellowCards += 1;
                                else {
                                    firstYellowCards += 1;
                                    doubleYellows.put(event.getPlayer(), game.matchesPlayed);
                                }
                            }
                            if (event.getType().equals("11")) {
                                redCards += 1;
                            }
                        }
                    }
                    for (Club club : StoredData.clubs) {
                        if (club.club.equals(event.getClub())) clubName = club.name;
                    }
                    storeCardLeaderboardList(clubName, firstYellowCards, secondYellowCards, redCards);
                    firstYellowCards = 0;
                    secondYellowCards = 0;
                    redCards = 0;
                }
            }
        }
        if (!cardLeaderboards.isEmpty()) { //SORTIRANJE PO BODOVIMA!!
            Set<Map.Entry<String, CardLeaderboard>> entrySet = cardLeaderboards.entrySet();
            List<Map.Entry<String, CardLeaderboard>> list = new ArrayList<>(entrySet);
            Collections.sort(list, ((o1, o2) -> o2.getValue().getAllCards() - o1.getValue().getAllCards()));
            System.out.printf("%40s %10s %20s %10s %30s%n",
                    "Klub", "Zuti", "Drugi zuti", "Crveni", "Ukupan br. kartona");

            list.forEach(k ->
                    System.out.printf("%40s %10s %20s %10s %30s%n",
                            k.getValue().getClubName(), k.getValue().getFirstYellowCards(),
                            k.getValue().getSecondYellowCards(), k.getValue().getRedCards(),
                            k.getValue().getAllCards()));
        }
    }

    private void storeCardLeaderboardList(String clubName, int firstYellowCards, int secondYellowCards, int redCards) {
        CardLeaderboard cardLeaderboard;
        if (!clubName.isEmpty() && !clubName.isBlank()) {
            if (!cardLeaderboards.containsKey(clubName)) {
                cardLeaderboard = new CardLeaderboard();
                cardLeaderboard.setClubName(clubName);
                cardLeaderboard.setFirstYellowCards(firstYellowCards);
                cardLeaderboard.setSecondYellowCards(secondYellowCards);
                cardLeaderboard.setRedCards(redCards);
                cardLeaderboard.setAllCards(firstYellowCards + secondYellowCards + redCards);
                cardLeaderboards.put(clubName, cardLeaderboard);
            } else {
                cardLeaderboard = cardLeaderboards.get(clubName);
                cardLeaderboard.setFirstYellowCards(cardLeaderboard.getFirstYellowCards() + firstYellowCards);
                cardLeaderboard.setSecondYellowCards(cardLeaderboard.secondYellowCards + secondYellowCards);
                cardLeaderboard.setRedCards(cardLeaderboard.redCards + redCards);
                cardLeaderboard.setAllCards(cardLeaderboard.allCards + firstYellowCards + secondYellowCards + redCards);
            }
        }
    }
}
