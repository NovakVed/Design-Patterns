package vednovak_zadaca_3.task;

public interface TableVisitor {
    void visit(GenerateCardTable generateCardTable);

    void visit(GenerateGoalTable generateGoalTable);

    void visit(GenerateMatchHistory generateMatchHistory);

    void visit(GenerateLeagueTable generateLeagueTable);
}
