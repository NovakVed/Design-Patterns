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

    //TODO popravi (ako je samo dva atributa da se ispise kojeg igraca nema i zasto) i ubaci vise pozicija
    boolean checkPlayerData(String[] object) {
        if (object.length != 4) {
            if (object.length == 3
                    && (!object[0].isBlank() || !object[1].isBlank() || !object[2].isBlank())) {
                System.out.printf("ERROR: igrač %10s nema datum rođenja%n", object[1]);
            } else if (object.length == 0) System.out.printf("ERROR: igrač nema sve podatake%n");
            else if (checkPlayerName(object)) System.out.printf("ERROR: igrač %10s nema sve podatken", object[1]);
            else System.out.printf("ERROR: igrač nema sve podatake%n");
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
            System.out.printf("ERROR: igrač %10s nema klub%n", object[1]);
            return false;
        }
        return true;
    }

    boolean checkPlayerName(String[] object) {
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.printf("ERROR: igrač nema imena%n");
            return false;
        }
        return true;
    }

    boolean checkPlayerPosition(String[] object) {
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.printf("ERROR: igrač %10s nema poziciju%n", object[1]);
            return false;
        }
        return true;
    }

    boolean checkPlayerBirthDate(String[] object) {
        if (object[3].isBlank() || object[3].isEmpty()) {
            System.out.printf("ERROR: igrač %10s nema datum rođenja%n", object[1]);
            return false;
        }
        return true;
    }
}
