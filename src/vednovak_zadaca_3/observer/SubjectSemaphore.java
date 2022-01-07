package vednovak_zadaca_3.observer;

import vednovak_zadaca_3.data.championship.MatchDetails;

import java.util.ArrayList;
import java.util.List;

public class SubjectSemaphore {
    private final List<ObserverSemaphore> observerSemaphores = new ArrayList<>();
    private MatchDetails matchDetails;
    private boolean home;
    private int homeGoals = 0;
    private int awayGoals = 0;
    private String homeScorer = "";
    private String awayScorer = "";

    public MatchDetails getMatchDetails() {
        return matchDetails;
    }

    public void setMatchDetails(MatchDetails matchDetails, boolean home) {
        this.matchDetails = matchDetails;
        this.home = home;
        notifyAllObservers();
    }

    public Boolean getHome() {
        return home;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public String getHomeScorer() {
        return homeScorer;
    }

    public void setHomeScorer(String homeScorer) {
        this.homeScorer += matchDetails.getMinutes() + "': " + homeScorer + ", ";
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals += homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public String getAwayScorer() {
        return awayScorer;
    }

    public void setAwayScorer(String awayScorer) {
        this.awayScorer += matchDetails.getMinutes() + "': " + awayScorer + ", ";
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals += awayGoals;
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
