package vednovak_zadaca_3;

import vednovak_zadaca_3.data.championship.MatchDetails;
import vednovak_zadaca_3.observer.AwayTeamObserver;
import vednovak_zadaca_3.observer.HomeTeamObserver;
import vednovak_zadaca_3.observer.SubjectSemaphore;
import vednovak_zadaca_3.observer.TimeObserver;
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
            if (task[0].equals("NU")) {
                if (!task[1].isEmpty()) {
                    LoadDirector loadDirector = new LoadDirector();
                    loadDirector.loadData("-u", task[1]);
                }
            }
            if (task[0].equals("NS")) {
                if (!task[1].isEmpty()) {
                    LoadDirector loadDirector = new LoadDirector();
                    loadDirector.loadData("-s", task[1]);
                }
            }
            if (task[0].equals("ND")) {
                if (!task[1].isEmpty()) {
                    LoadDirector loadDirector = new LoadDirector();
                    loadDirector.loadData("-d", task[1]);
                }
            }
            if (task[0].equals("D")) {
                if (!task[1].isEmpty() && !task[2].isEmpty() && !task[3].isEmpty() && !task[4].isEmpty()) {
                    MatchDetails matchDetails = null;
                    int millis = Integer.parseInt(task[4]) * 1000;
                    for (MatchDetails m : StoredData.matches.values()) {
                        if (m.getRound() == Integer.parseInt(task[1])
                                && m.getHomeTeam().equals(task[2]) && m.getAwayTeam().equals(task[3])) {
                            matchDetails = m;
                        }
                    }
                    if (matchDetails != null) {
                        SubjectSemaphore subjectSemaphore = new SubjectSemaphore();
                        new TimeObserver(subjectSemaphore);
                        new HomeTeamObserver(subjectSemaphore);
                        new AwayTeamObserver(subjectSemaphore);

                        for (MatchDetails details : matchDetails.getMatchEvents()) {
                            boolean home = false;
                            if (!details.getType().equals("0") && !details.getType().equals("99"))
                                home = details.getClubID().equals(matchDetails.getHomeTeam());
                            try {
                                Thread.sleep(millis);
                                subjectSemaphore.setMatchDetails(details, home);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
