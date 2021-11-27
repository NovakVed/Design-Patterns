package vednovak_zadaca_1.task;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Club;
import vednovak_zadaca_1.data.Event;
import vednovak_zadaca_1.data.Match;
import vednovak_zadaca_1.table.CardTable;

import java.util.*;

public class GenerateCardTable implements Task {
    private final int round;
    public Map<String, CardTable> cardLeaderboards = new HashMap<>();
    public Map<String, Integer> doubleYellows = new HashMap<>();

    GenerateCardTable() {
        this.round = StoredData.matches.get(StoredData.matches.size() - 1).matchID;
        printTable();
    }

    GenerateCardTable(String round) {
        this.round = Integer.parseInt(round);
        printTable();
    }

    public void printTable() {
        for (Match match : StoredData.matches) {
            if (match.round <= round) {
                String clubName = "";
                int firstYellowCards = 0;
                int secondYellowCards = 0;
                int redCards = 0;

                for (Event event : StoredData.events) {
                    if (match.matchID == event.getMatchID()) {
                        if (event.getClub() != null) {
                            if (event.getType().equals("10")) {
                                if (doubleYellows.containsKey(event.getPlayer()))
                                    secondYellowCards += 1;
                                else {
                                    firstYellowCards += 1;
                                    doubleYellows.put(event.getPlayer(), match.round);
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
                    if (secondYellowCards != 0) redCards += 1;
                    storeCardLeaderboardList(clubName, firstYellowCards, secondYellowCards, redCards);
                    firstYellowCards = 0;
                    secondYellowCards = 0;
                    redCards = 0;
                }
            }
        }
        if (!cardLeaderboards.isEmpty()) { //SORTIRANJE PO BODOVIMA!!
            Set<Map.Entry<String, CardTable>> entrySet = cardLeaderboards.entrySet();
            List<Map.Entry<String, CardTable>> list = new ArrayList<>(entrySet);
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
        CardTable cardTable;
        if (!clubName.isEmpty() && !clubName.isBlank()) {
            if (!cardLeaderboards.containsKey(clubName)) {
                cardTable = new CardTable.Builder()
                        .setClubName(clubName)
                        .setFirstYellowCards(firstYellowCards)
                        .setSecondYellowCards(secondYellowCards)
                        .setRedCards(redCards)
                        .setAllCards(firstYellowCards + secondYellowCards + redCards)
                        .build();
                cardLeaderboards.put(clubName, cardTable);
            } else {
                cardTable = cardLeaderboards.get(clubName);
                cardTable.firstYellowCards = cardTable.getFirstYellowCards() + firstYellowCards;
                cardTable.secondYellowCards = cardTable.secondYellowCards + secondYellowCards;
                cardTable.redCards = cardTable.redCards + redCards;
                cardTable.allCards = cardTable.allCards + firstYellowCards + secondYellowCards + redCards;
            }
        }
    }
}
