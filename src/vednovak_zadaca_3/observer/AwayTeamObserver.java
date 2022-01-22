package vednovak_zadaca_3.observer;

import vednovak_zadaca_3.data.club.state.PlayerRemovedFromGame;
import vednovak_zadaca_3.data.club.state.PlayerSubstitute;

public class AwayTeamObserver extends ObserverSemaphore {
    public AwayTeamObserver(SubjectSemaphore subjectSemaphore) {
        this.subjectSemaphore = subjectSemaphore;
        this.subjectSemaphore.attach(this);
    }

    @Override
    public void update() {
        if (!subjectSemaphore.getHome()) {
            if (subjectSemaphore.getMatchDetails().getType().equals("1")
                    || subjectSemaphore.getMatchDetails().getType().equals("2")) {
                subjectSemaphore.setAwayGoals(1);
                subjectSemaphore.setAwayScorer(subjectSemaphore.getMatchDetails().getPlayerName());
                System.out.printf("%40s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Strijelac: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("3")) {
                subjectSemaphore.setHomeGoals(1);
                subjectSemaphore.setHomeScorer(subjectSemaphore.getMatchDetails().getPlayerName());
                System.out.printf("%40s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Autogol: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("10")) {
                System.out.printf("%40s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Žuti karton: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("11")) {
                System.out.printf("%40s'%s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Crveni karton: ",
                        subjectSemaphore.getMatchDetails().getPlayer());
                PlayerRemovedFromGame playerRemovedFromGame = new PlayerRemovedFromGame();
                playerRemovedFromGame.doAction(subjectSemaphore.getMatchDetails().getPlayer());
            }
            if (subjectSemaphore.getMatchDetails().getType().equals("20")) {
                System.out.printf("%40s'%s%n%40s%s%n%40s%s%n",
                        subjectSemaphore.getMatchDetails().getMinutes(), " Zamijena igrača",
                        "Izlazi: ", subjectSemaphore.getMatchDetails().getPlayer(),
                        "Ulazi: ", subjectSemaphore.getMatchDetails().getSubstitute());
                PlayerSubstitute playerSubstitute = new PlayerSubstitute();
                playerSubstitute.doAction(subjectSemaphore.getMatchDetails().getPlayer());
                playerSubstitute.doAction(subjectSemaphore.getMatchDetails().getSubstitute());
            }
        }
    }
}
