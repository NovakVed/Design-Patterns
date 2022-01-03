package vednovak_zadaca_3.observer;

public class AwayTeamObserver extends ObserverSemaphore {
    private int goals = 0;
    private String scorer = "";

    public AwayTeamObserver(SubjectSemaphore subjectSemaphore) {
        this.subjectSemaphore = subjectSemaphore;
        this.subjectSemaphore.attach(this);
    }

    @Override
    public void update() {
        if (scorer != null)
            System.out.printf("%45s %15d%n%45s %15s%n",
                    "Gol GOSTI: ", goals,
                    "Strijelci: ", scorer);
        else
            System.out.printf("%45s %15d%n",
                    "Gol GOSTI: ", 0);
        if (!subjectSemaphore.getHome()) {
            if (subjectSemaphore.getEvent().getType().equals("1")
                    || subjectSemaphore.getEvent().getType().equals("2")) {
                goals += 1;
                scorer += subjectSemaphore.getEvent().getPlayer() + ", ";
                System.out.printf("%n%45s %15s%n%45s %15s%n",
                        "Strijelac: ", subjectSemaphore.getEvent().getPlayer(),
                        "Minuta: ", subjectSemaphore.getEvent().getMinutes());
            }
            if (subjectSemaphore.getEvent().getType().equals("10")) {
                System.out.printf("%45s%n%45s %15s%n%45s %15s%n",
                        "Događaj: Žuti karton",
                        "Igrač: ", subjectSemaphore.getEvent().getPlayer(),
                        "Minuta: ", subjectSemaphore.getEvent().getMinutes());
            }
            if (subjectSemaphore.getEvent().getType().equals("11")) {
                System.out.printf("%45s%n%45s %15s%n%45s %15s%n",
                        "Događaj: Crveni karton",
                        "Igrač: ", subjectSemaphore.getEvent().getPlayer(),
                        "Minuta: ", subjectSemaphore.getEvent().getMinutes());
            }
            if (subjectSemaphore.getEvent().getType().equals("20")) {
                System.out.printf("%45s%n%45s %15s%n%45s %15s%n%45s %15s%n",
                        "Događaj: Zamijena igrača",
                        "Igrač: ", subjectSemaphore.getEvent().getPlayer(),
                        "Igrač: ", subjectSemaphore.getEvent().getSubstitute(),
                        "Minuta: ", subjectSemaphore.getEvent().getMinutes());
            }
        }
    }
}
