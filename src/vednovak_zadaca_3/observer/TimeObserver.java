package vednovak_zadaca_1.observer;

public class TimeObserver extends ObserverSemaphore {
    public TimeObserver(SubjectSemaphore subjectSemaphore) {
        this.subjectSemaphore = subjectSemaphore;
        this.subjectSemaphore.attach(this);
    }

    @Override
    public void update() {
        System.out.printf("--------------------------------------------------------------------%n" +
                "%s%30s%n",
                "VRIJEME:", subjectSemaphore.getEvent().getMinutes());
    }
}
