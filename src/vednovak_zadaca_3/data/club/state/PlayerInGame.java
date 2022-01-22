package vednovak_zadaca_3.data.club.state;

import vednovak_zadaca_3.data.club.Player;

public class PlayerInGame implements InGamePlayerState {
    @Override
    public void doAction(Player player) {
        if (player != null)
            player.setState(this);
    }

    public String toString() {
        return "S";
    }
}
