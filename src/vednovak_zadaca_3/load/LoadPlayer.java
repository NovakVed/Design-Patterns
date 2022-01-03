package vednovak_zadaca_3.load;

import vednovak_zadaca_3.data.club.Player;
import vednovak_zadaca_3.data.club.position.PlayerPosition;

import java.util.ArrayList;

class LoadPlayer extends LoadData {
    ArrayList<String> positions = new ArrayList<>();

    LoadPlayer() {
    }

    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            Player player = new Player(objectData[0], objectData[1], positions, objectData[3]);
            positions.clear();
            if (LoadFileStoredData.players.contains(player))
                System.out.println("ERROR: igrač već postoji");
            LoadFileStoredData.players.add(player);
        }
    }

    boolean checkObjectData(String[] object) {
        return checkPlayerData(object);
    }

    //TODO ubaci vise pozicija
    boolean checkPlayerData(String[] object) {
        if (object.length != 4) {
            if (object.length == 3
                    && (!object[0].isBlank() || !object[1].isBlank() || !object[2].isBlank())) {
                System.out.print("ERROR: igrač nema datum rođenja: ");
                printData(object);
            } else if (object.length == 0) System.out.printf("ERROR: igrač nema sve podatake%n");
            else if (checkPlayerName(object)) {
                System.out.print("ERROR: igrač nema sve podatkene: ");
                printData(object);
            } else System.out.printf("ERROR: igrač nema podatake%n");
            return false;
        }
        if (!checkPlayerClub(object)) return false;
        if (!checkPlayerName(object)) return false;
        //TODO printData(object) so you dont have to write in method
        if (!checkPlayerPosition(object)) {
            printData(object);
            return false;
        }
        return checkPlayerBirthDate(object);
    }

    boolean checkPlayerClub(String[] object) {
        if (object[0].isBlank() || object[0].isEmpty()) {
            System.out.print("ERROR: igrač nema klub: ");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkPlayerName(String[] object) {
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.print("ERROR: igrač nema imena: ");
            printData(object);
            return false;
        }
        return true;
    }

    //TODO popravi!!
    boolean checkPlayerPosition(String[] object) {
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.print("ERROR: igrač nema poziciju: ");
            return false;
        }
        String[] playerPositions = object[2].split(", ");
        if (playerPositions.length == 1) {
            if (checkIfPlayerPositionIsValid(playerPositions[0])) {
                positions.add(playerPositions[0]);
                return true;
            }
            System.out.print("ERROR: igrač ima poziciju koja ne postoji: ");
            return false;
        }
        if (playerPositions.length > 1) {
            for (String position : playerPositions) {
                if (positions.contains(position)) {
                    System.out.print("ERROR: igrač ima dvije iste pozicije: ");
                    return false;
                }
                int currentPlayerListSize = positions.size();

                //TODO
                if (checkIfPlayerPositionIsValid(position)) positions.add(position);

                if (currentPlayerListSize == positions.size()) {
                    System.out.print("ERROR: igrač ima poziciju koja ne postoji: ");
                    return false;
                }
            }
            if (positions.isEmpty()) {
                System.out.print("ERROR: igrač ima poziciju koja ne postoji: ");
                return false;
            }
        }
        return true;
    }

    boolean checkIfPlayerPositionIsValid(String position) {
        for (PlayerPosition playerPosition : PlayerPosition.values()) {
            if (position.equals(playerPosition.toString())) {
                return true;
            }
        }
        return false;
    }

    boolean checkPlayerBirthDate(String[] object) {
        if (object[3].isBlank() || object[3].isEmpty()) {
            System.out.print("ERROR: igrač nema datum rođenja: ");
            printData(object);
            return false;
        }
        return true;
    }
}
