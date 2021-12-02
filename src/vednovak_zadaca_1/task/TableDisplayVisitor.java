package vednovak_zadaca_1.task;

import vednovak_zadaca_1.table.CardTable;
import vednovak_zadaca_1.table.LeagueTable;
import vednovak_zadaca_1.table.ScorerTable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TableDisplayVisitor implements TableVisitor {

    @Override
    public void visit(GenerateCardTable generateCardTable) {
        if (!generateCardTable.cardLeaderboards.isEmpty()) {
            List<CardTable> list = new ArrayList<>(generateCardTable.cardLeaderboards.values());
            int sumFirstYellowCards = 0;
            int sumSecondYellowCards = 0;
            int sumRedCards = 0;
            int sumAllCards = 0;
            for (CardTable cardTable : list) {
                sumFirstYellowCards += cardTable.getFirstYellowCards();
                sumSecondYellowCards += cardTable.getSecondYellowCards();
                sumRedCards += cardTable.getRedCards();
                sumAllCards += cardTable.getAllCards();
            }
            list.sort(Comparator.comparing(CardTable::getAllCards)
                    .thenComparing(CardTable::getRedCards)
                    .thenComparing(CardTable::getSecondYellowCards).reversed());
            System.out.printf("%-40s %10s %20s %10s %30s%n",
                    "Klub", "Zuti", "Drugi zuti", "Crveni", "Ukupan br. kartona");

            list.forEach(k ->
                    System.out.printf("%-40s %10s %20s %10s %30s%n",
                            k.getClubName(), k.getFirstYellowCards(),
                            k.getSecondYellowCards(), k.getRedCards(),
                            k.getAllCards()));

            System.out.printf("%-40s %10s %20s %10s %30s%n",
                    "SUMA:", sumFirstYellowCards, sumSecondYellowCards, sumRedCards, sumAllCards);
        }
    }

    @Override
    public void visit(GenerateGoalTable generateGoalTable) {
        if (!generateGoalTable.scorerLeaderboards.isEmpty()) {
            List<ScorerTable> list = new ArrayList<>(generateGoalTable.scorerLeaderboards.values());
            int scoredGoals = 0;
            for (ScorerTable scorerTable : list) scoredGoals += scorerTable.getGoals();
            list.sort(Comparator.comparing(ScorerTable::getGoals).reversed());
            System.out.printf("%-40s %-40s %20s%n", "Igrac", "Klub", "Golovi");

            list.forEach(k ->
                    System.out.printf("%-40s %-40s %20s%n",
                            k.getPlayerName(), k.getClubName(),
                            k.getGoals()));
            System.out.printf("%-40s %40s %20s%n", "SUMA:", "", scoredGoals);
        }
    }

    @Override
    public void visit(GenerateMatchHistory generateMatchHistory) {
        System.out.printf("%5s %-25s %-25s %15s %20s%n",
                "Kolo", "Domaćin", "Gost", "Rezultat", "Datum");
        generateMatchHistory.matchHistoryHashMap.forEach((k, v) ->
                System.out.printf("%5s %-25s %-25s %15s %20s%n",
                        v.getRound(), v.getHomeTeam(), v.getAwayTeam(), v.getGameScore(), v.getDate())
        );
    }

    @Override
    public void visit(GenerateLeagueTable generateLeagueTable) {
        if (!generateLeagueTable.leagueLeaderboards.isEmpty()) {
            List<LeagueTable> list = new ArrayList<>(generateLeagueTable.leagueLeaderboards.values());
            int sumWon = 0;
            int sumDraw = 0;
            int sumLost = 0;
            int sumGoalsFor = 0;
            int sumGoalsAgainst = 0;
            int points = 0;
            for (LeagueTable leagueTable : generateLeagueTable.leagueLeaderboards.values()) {
                sumWon += leagueTable.getWon();
                sumDraw += leagueTable.getDrawn();
                sumLost += leagueTable.getLost();
                sumGoalsFor += leagueTable.getGoalsFor();
                sumGoalsAgainst += leagueTable.getGoalsAgainst();
                points += leagueTable.getPoints();
            }
            list.sort(Comparator.comparing(LeagueTable::getPoints)
                    .thenComparing(LeagueTable::getGoalsDifference)
                    .thenComparing(LeagueTable::getWon).reversed());

            System.out.printf("%-20s %-20s %6s %6s %6s %6s %6s %6s %6s %10s%n",
                    "Klub", "Trener", "Kolo", "DO", "NE", "IZ", "ZA", "PG", "Razlika", "Bodovi");

            list.forEach(k ->
                    System.out.printf("%-20s %-20s %6s %6s %6s %6s %6s %6s %6s %10s%n",
                            k.getClub(), k.getCoach(), k.getMatchesPlayed(),
                            k.getWon(), k.getDrawn(), k.getLost(),
                            k.getGoalsFor(), k.getGoalsAgainst(),
                            k.getGoalsDifference(), k.getPoints()));
            System.out.printf("%-20s %-20s %6s %6s %6s %6s %6s %6s %6s %10s%n",
                    "SUMA:", "", "", sumWon, sumDraw, sumLost, sumGoalsFor, sumGoalsAgainst,
                    sumGoalsFor - sumGoalsAgainst, points);
        }
    }
}
