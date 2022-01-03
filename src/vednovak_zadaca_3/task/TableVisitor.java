package vednovak_zadaca_1.task;

public interface TableVisitor {
    void visit(GenerateCardTable generateCardTable);

    void visit(GenerateGoalTable generateGoalTable);

    void visit(GenerateMatchHistory generateMatchHistory);

    void visit(GenerateLeagueTable generateLeagueTable);
}
