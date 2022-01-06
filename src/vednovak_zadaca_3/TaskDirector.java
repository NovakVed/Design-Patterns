package vednovak_zadaca_3;

import vednovak_zadaca_3.data.championship.Match;
import vednovak_zadaca_3.data.championship.MatchDetails;
import vednovak_zadaca_3.observer.*;
import vednovak_zadaca_3.task.GenerateTableFactory;
import vednovak_zadaca_3.task.TableDisplayVisitor;

public class TaskDirector {
    public void directTask(String[] task) {
        if (task[0].equals("0") || task[0].isEmpty()) return;

        if (task[0].equals("T") || task[0].equals("S") || task[0].equals("K") || task[0].equals("R")) {
            GenerateTableFactory generateTableFactory = new GenerateTableFactory();
            if (generateTableFactory.getTaskResult(task) != null)
                generateTableFactory.getTaskResult(task).accept(new TableDisplayVisitor());
            else System.out.println("ERROR: Unesena je nepostojeća komanda");
        } else {
            switch (task[0]) {
                case "NU":
                    if (!task[1].isEmpty()) {
                        LoadDirector loadDirector = new LoadDirector();
                        loadDirector.loadData("-u", task[1]);
                    }
                case "NS":
                    if (!task[1].isEmpty()) {
                        LoadDirector loadDirector = new LoadDirector();
                        loadDirector.loadData("-s", task[1]);
                    }
                case "ND":
                    if (!task[1].isEmpty()) {
                        LoadDirector loadDirector = new LoadDirector();
                        loadDirector.loadData("-d", task[1]);
                    }
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
                                    subjectSemaphore.setEvent(match.homeTeam.equals(event.getClubID()), event);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                default:
                    System.out.println("ERROR: Unesena je nepostojeća komanda");
            }
        }
    }
}
