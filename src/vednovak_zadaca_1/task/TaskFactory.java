package vednovak_zadaca_1.task;

public class TaskFactory {
    public Task getTaskResult(String[] task) {
        if (task[0].equals("0")) return null;
        if (task[0].isEmpty()) return null;
        switch (task[0]) {
            case "T":
                if (ValidateCommand(task)) return null;
                if (task.length == 1) return new TaskGenerateLeagueLeaderboard();
                return new TaskGenerateLeagueLeaderboard(task[1]);
            case "S":
                if (ValidateCommand(task)) return null;
                if (task.length == 1) return new TaskGenerateGoalLeaderboard();
                return new TaskGenerateGoalLeaderboard(task[1]);
            case "K":
                if (ValidateCommand(task)) return null;
                if (task.length == 1) return new TaskGenerateCardLeaderboard();
                return new TaskGenerateCardLeaderboard(task[1]);
            case "R":
                //TODO
                if (ValidateCommand(task)) return null;
                break;
            default:
                System.out.println("ERROR: Unesena je nepostojeća komanda");
                return null;
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
