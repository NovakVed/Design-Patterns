package vednovak_zadaca_3.task;

public class GenerateTableFactory {
    public Table getTaskResult(String[] task) {
        if (task[0].equals("0") || task[0].isEmpty()) return null;
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
                return null;
        }
    }

    private Boolean ValidateCommand(String[] task) {
        if (task[0].equals("R")) {
            if (task.length > 3) return true;
            if (task.length != 1) {
                if (!CheckIfStringIsCharacter(task[1])) {
                    System.out.println("ERROR: 2. mjesto nije ID kluba");
                    return true;
                }
                if (task.length != 2) {
                    if (!CheckIfStringIsNumber(task[2])) {
                        System.out.println("ERROR: 3. mjesto nije broj kola");
                        return true;
                    }
                }
            }
        } else {
            if (task.length > 2) return true;
            if (task.length != 1) {
                if (!CheckIfStringIsNumber(task[1])) {
                    System.out.println("ERROR: 2. mjesto nije broj kola");
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean CheckIfStringIsCharacter(String string) {
        return string.matches("^[A-Z]$");
    }

    private Boolean CheckIfStringIsNumber(String string) {
        return string.matches("^[0-9]+$");
    }
}
