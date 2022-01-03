package vednovak_zadaca_3.observer;

public class RestGameObserver extends ObserverSemaphore {
    public RestGameObserver(SubjectSemaphore subjectSemaphore) {
        this.subjectSemaphore = subjectSemaphore;
        this.subjectSemaphore.attach(this);
    }

    @Override
    public void update() {
        if (subjectSemaphore.getEvent().getType().equals("0")) {
            System.out.printf("%-15s%n", "Početak utakmice!");
        }
        if (subjectSemaphore.getEvent().getType().equals("99")) {
            System.out.printf("%-15s%n", "Kraj utakmice!");
        }
    }
}
