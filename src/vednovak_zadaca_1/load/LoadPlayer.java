package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.club.Player;

class LoadPlayer extends LoadData {
    LoadPlayer() {
    }

    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            Player player = new Player(objectData[0], objectData[1], objectData[2], objectData[3]);
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
            }
            else System.out.printf("ERROR: igrač nema podatake%n");
            return false;
        }
        if (!checkPlayerClub(object)) return false;
        if (!checkPlayerName(object)) return false;
        if (!checkPlayerPosition(object)) return false;
        if (!checkPlayerBirthDate(object)) return false;
        return true;
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

    boolean checkPlayerPosition(String[] object) {
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.print("ERROR: igrač nema poziciju: ");
            printData(object);
            return false;
        }
        return true;
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
