package vednovak_zadaca_3.observer;

public class TimeObserver extends ObserverSemaphore {
    public TimeObserver(SubjectSemaphore subjectSemaphore) {
        this.subjectSemaphore = subjectSemaphore;
        this.subjectSemaphore.attach(this);
    }

    public void update() {
        System.out.printf(
                "--------------------------------------------------------------------%n" + "%32s'%n" +
                        "--------------------------------------------------------------------%n",
                subjectSemaphore.getMatchDetails().getMinutes());
        System.out.printf("%30d : %d%n", subjectSemaphore.getHomeGoals(), subjectSemaphore.getAwayGoals());

        if (!subjectSemaphore.getHomeScorer().isEmpty() || !subjectSemaphore.getAwayScorer().isEmpty())
            System.out.printf("%-30s | %10s%n", subjectSemaphore.getHomeScorer(), subjectSemaphore.getAwayScorer());

        if (subjectSemaphore.getMatchDetails().getType().equals("0"))
            System.out.printf("%40s%n", "Početak utakmice!");

        if (subjectSemaphore.getMatchDetails().getType().equals("99"))
            System.out.printf("%40s%n", "Kraj utakmice!");
        System.out.printf("--------------------------------------------------------------------%n");
    }
}
