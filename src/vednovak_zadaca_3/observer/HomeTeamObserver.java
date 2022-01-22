package vednovak_zadaca_3.observer;

import vednovak_zadaca_3.data.club.state.PlayerRemovedFromGame;
import vednovak_zadaca_3.data.club.state.PlayerSubstitute;

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
                subjectSemaphore.setHomeScorer(subjectSemaphore.getMatchDetails().getPlayerName());
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Strijelac: ",
                        subjectSemaphore.getMatchDetails().getPlayerName());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("3")) {
                subjectSemaphore.setAwayGoals(1);
                subjectSemaphore.setAwayScorer(subjectSemaphore.getMatchDetails().getPlayerName());
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Autogol: ",
                        subjectSemaphore.getMatchDetails().getPlayerName());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("10")) {
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Žuti karton: ",
                        subjectSemaphore.getMatchDetails().getPlayerName());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("11")) {
                System.out.printf("%s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Crveni karton: ",
                        subjectSemaphore.getMatchDetails().getPlayerName());
                PlayerRemovedFromGame playerRemovedFromGame = new PlayerRemovedFromGame();
                playerRemovedFromGame.doAction(subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("20")) {
                System.out.printf("%s'%s%n%s%s%n%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Zamijena igrača",
                        "Izlazi: ", subjectSemaphore.getMatchDetails().getPlayerName(),
                        "Ulazi: ", subjectSemaphore.getMatchDetails().getSubstituteName());
                PlayerSubstitute playerSubstitute = new PlayerSubstitute();
                playerSubstitute.doAction(subjectSemaphore.getMatchDetails().getPlayer());
                playerSubstitute.doAction(subjectSemaphore.getMatchDetails().getSubstitute());
            }
        }
    }
}
