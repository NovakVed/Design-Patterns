package vednovak_zadaca_3.data.club.state;

import vednovak_zadaca_3.data.club.Player;

public class PlayerSubstitute implements InGamePlayerState {
    @Override
    public void doAction(Player player) {
        if (player != null) {
            if (player.getState().toString().equals("S")) {
                PlayerInSubstitution playerInSubstitution = new PlayerInSubstitution();
                playerInSubstitution.doAction(player);
            } else if (player.getState().toString().equals("P")) {
                PlayerInGame playerInGame = new PlayerInGame();
                playerInGame.doAction(player);
            }
        }
    }

    public String toString() {
        return "Zamijenjen";
    }
}
