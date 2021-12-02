package vednovak_zadaca_1.task;

import vednovak_zadaca_1.LoadFactory;

public class TaskFactory {
    public void getTaskResult(String[] task) {
        if (task[0].equals("0")) return;
        if (task[0].isEmpty()) return;
        switch (task[0]) {
            case "T":
                if (ValidateCommand(task)) return;
                if (task.length == 1) {
                    new GenerateLeagueTable().accept(new TableDisplayVisitor());
                    return;
                }
                new GenerateLeagueTable(task[1]).accept(new TableDisplayVisitor());
                return;
            case "S":
                if (ValidateCommand(task)) return;
                if (task.length == 1) {
                    new GenerateGoalTable().accept(new TableDisplayVisitor());
                    return;
                }
                new GenerateGoalTable(task[1]).accept(new TableDisplayVisitor());
                return;
            case "K":
                if (ValidateCommand(task)) return;
                if (task.length == 1) {
                    new GenerateCardTable().accept(new TableDisplayVisitor());
                    return;
                }
                new GenerateCardTable(task[1]).accept(new TableDisplayVisitor());
                return;
            case "R":
                if (ValidateCommand(task)) return;
                if (task.length == 2) {
                    new GenerateMatchHistory(task[1]).accept(new TableDisplayVisitor());
                    return;
                }
                if (task.length == 3) {
                    new GenerateMatchHistory(task[1], task[2]).accept(new TableDisplayVisitor());
                    return;
                }
                return;
            case "NU":
                if (!task[1].isEmpty()) {
                    LoadFactory loadFactory = new LoadFactory();
                    loadFactory.loadData("-u", task[1]);
                }
                return;
            case "NS":
                if (!task[1].isEmpty()) {
                    LoadFactory loadFactory = new LoadFactory();
                    loadFactory.loadData("-s", task[1]);
                }
                return;
            case "ND":
                if (!task[1].isEmpty()) {
                    LoadFactory loadFactory = new LoadFactory();
                    loadFactory.loadData("-d", task[1]);
                }
                return;
            default:
                System.out.println("ERROR: Unesena je nepostojeća komanda");
        }
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
