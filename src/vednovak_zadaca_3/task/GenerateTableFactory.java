package vednovak_zadaca_3.task;

public class GenerateTableFactory {
    public Table getTaskResult(String[] task) {
        if (task[0].equals("0")) return null;
        if (task[0].isEmpty()) return null;
        switch (task[0]) {
            case "T":
                if (ValidateCommand(task)) return null;
                if (task.length == 1) {
                    return new GenerateLeagueTable();
                }
                return new GenerateLeagueTable(task[1]);
            case "S":
                if (ValidateCommand(task)) return null;
                if (task.length == 1) {
                    return new GenerateGoalTable();
                }
                return new GenerateGoalTable(task[1]);
            case "K":
                if (ValidateCommand(task)) return null;
                if (task.length == 1) {
                    return new GenerateCardTable();
                }
                return new GenerateCardTable(task[1]);
            case "R":
                if (ValidateCommand(task)) return null;
                if (task.length == 2) {
                    return new GenerateMatchHistory(task[1]);
                }
                if (task.length == 3) {
                    return new GenerateMatchHistory(task[1], task[2]);
                }
                return null;
            default:
                System.out.println("ERROR: Unesena je nepostojeća komanda");
        }
        return null;
    }

    private Boolean ValidateCommand(String[] task) {
        if (task[0].equals("R")) {
            if (task.length > 3) {
                System.out.println("ERROR: Unesena je nepravilna komanda");
                return true;
            }
        } else {
            if (task.length > 2) {
                System.out.println("ERROR: Unesena je nepravilna komanda");
                return true;
            }
        }
        return false;
    }
}
