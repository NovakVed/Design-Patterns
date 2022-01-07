package vednovak_zadaca_3.observer;

public class HomeTeamObserver extends ObserverSemaphore {
    public HomeTeamObserver(SubjectSemaphore subjectSemaphore) {
        this.subjectSemaphore = subjectSemaphore;
        this.subjectSemaphore.attach(this);
    }

    @Override
    public void update() {
        if (subjectSemaphore.getHome()) {
            if (subjectSemaphore.getMatchDetails().getType().equals("1")
                    || subjectSemaphore.getMatchDetails().getType().equals("2")) {
                subjectSemaphore.setHomeGoals(1);
                subjectSemaphore.setHomeScorer(subjectSemaphore.getMatchDetails().getPlayer());
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Strijelac: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("3")) {
                subjectSemaphore.setAwayGoals(1);
                subjectSemaphore.setAwayScorer(subjectSemaphore.getMatchDetails().getPlayer());
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Autogol: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("10")) {
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Žuti karton: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("11")) {
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Crveni karton: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("20")) {
                System.out.printf("%s'%s%n%s%s%n%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Zamijena igrača",
                        "Izlazi: ", subjectSemaphore.getMatchDetails().getPlayer(),
                        "Ulazi: ", subjectSemaphore.getMatchDetails().getSubstitute());
            }
        }
    }
}
