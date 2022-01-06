package vednovak_zadaca_3.task;

public interface Table {
    void accept(TableVisitor tableVisitor);

    void generateTable();
}
