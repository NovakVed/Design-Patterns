package vednovak_zadaca_3.observer;

import vednovak_zadaca_3.data.championship.MatchDetails;

import java.util.ArrayList;
import java.util.List;

public class SubjectSemaphore {
    private final List<ObserverSemaphore> observerSemaphores = new ArrayList<>();
    private MatchDetails event;
    private Boolean home;

    public MatchDetails getEvent() {
        return event;
    }

    public boolean getHome() {
        return home;
    }

    public void setEvent(Boolean home, MatchDetails event) {
        this.event = event;
        this.home = home;
        notifyAllObservers();
    }

    public void attach(ObserverSemaphore observerSemaphore) {
        observerSemaphores.add(observerSemaphore);
    }

    public void detach(ObserverSemaphore observerSemaphore) {
        observerSemaphores.remove(observerSemaphore);
    }

    public void notifyAllObservers() {
        for (ObserverSemaphore observerSemaphore : observerSemaphores) {
            observerSemaphore.update();
        }
    }
}
