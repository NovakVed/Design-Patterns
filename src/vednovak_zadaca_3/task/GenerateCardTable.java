package vednovak_zadaca_3.task;

import vednovak_zadaca_3.StoredData;
import vednovak_zadaca_3.data.championship.Match;
import vednovak_zadaca_3.data.championship.MatchDetails;
import vednovak_zadaca_3.data.club.Club;
import vednovak_zadaca_3.table.CardTable;

import java.util.HashMap;
import java.util.Map;

public class GenerateCardTable implements Table {
    private final int round;
    public Map<String, CardTable> cardLeaderboards = new HashMap<>();
    public Map<String, Integer> doubleYellows = new HashMap<>();

    GenerateCardTable() {
        this.round = StoredData.matches.size();
        generateTable();
    }

    GenerateCardTable(String round) {
        this.round = Integer.parseInt(round);
        generateTable();
    }

    public void generateTable() {
        for (Match match : StoredData.matches.values()) {
            if (match.round <= round) {
                String clubName = "";
                int firstYellowCards = 0;
                int secondYellowCards = 0;
                int redCards = 0;

                for (MatchDetails matchDetails : match.getMatchEvents()) {
                    if (matchDetails.getClubID() != null) {
                        if (matchDetails.getType().equals("10")) {
                            if (doubleYellows.containsKey(matchDetails.getPlayerName()))
                                secondYellowCards += 1;
                            else {
                                firstYellowCards += 1;
                                doubleYellows.put(matchDetails.getPlayerName(), match.round);
                            }
                        }
                        if (matchDetails.getType().equals("11")) {
                            redCards += 1;
                        }
                    }
                    for (Club club : StoredData.clubs.values()) {
                        if (club.clubID.equals(matchDetails.getClubID())) clubName = club.name;
                    }
                    if (secondYellowCards != 0) redCards += 1;
                    storeCardLeaderboardList(clubName, firstYellowCards, secondYellowCards, redCards);
                    firstYellowCards = 0;
                    secondYellowCards = 0;
                    redCards = 0;
                }
            }
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

    @Override
    public void accept(TableVisitor tableVisitor) {
        tableVisitor.visit(this);
    }
}
