package vednovak_zadaca_1.task;

import vednovak_zadaca_1.LoadFactory;
import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.championship.Match;
import vednovak_zadaca_1.data.championship.MatchDetails;
import vednovak_zadaca_1.observer.*;

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
            case "D":
                if (!task[1].isEmpty() && !task[2].isEmpty() && !task[3].isEmpty() && !task[4].isEmpty()) {
                    Match match = null;
                    int millis = Integer.parseInt(task[4]) * 1000;
                    for (Match m : StoredData.matches.values()) {
                        if (m.round == Integer.parseInt(task[1])
                                && m.homeTeam.equals(task[2]) && m.awayTeam.equals(task[3])) {
                            match = m;
                        }
                    }
                    if (match != null) {
                        SubjectSemaphore subjectSemaphore = new SubjectSemaphore();
                        new RestGameObserver(subjectSemaphore);
                        new TimeObserver(subjectSemaphore);
                        new HomeTeamObserver(subjectSemaphore);
                        new AwayTeamObserver(subjectSemaphore);

                        for (MatchDetails event : match.matchEvents) {
                            try {
                                //TODO autogolovi
                                Thread.sleep(millis);
                                if (match.homeTeam.equals(event.getClubID())) subjectSemaphore.setEvent(true, event);
                                else subjectSemaphore.setEvent(false, event);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
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
