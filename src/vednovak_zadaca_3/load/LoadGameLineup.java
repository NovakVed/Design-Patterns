package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.championship.GameLineup;

class LoadGameLineup extends LoadData {
    LoadGameLineup() {
    }

    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            GameLineup gameLineup = new GameLineup(Integer.parseInt(objectData[0]),
                    objectData[1], objectData[2], objectData[3], objectData[4]);
            if (LoadFileStoredData.gameLineups.contains(gameLineup))
                System.out.println("ERROR: sastav utakmice već postoji");
            LoadFileStoredData.gameLineups.add(gameLineup);
        }
    }

    boolean checkObjectData(String[] object) {
        return checkGameLineupData(object);
    }

    boolean checkGameLineupData(String[] object) {
        if (object.length != 5) {
            if (object.length == 4 && (!object[0].isBlank() || !object[1].isBlank()
                    || !object[2].isBlank() || !object[3].isBlank())) {
                System.out.print("ERROR: sastavi_utakmice nema poziciju: ");
                printData(object);
            } else {
                System.out.printf("ERROR: sastavi_utakmice nema sve podatake%n");
            }
            return false;
        }
        if (!checkIfGameLineupIdExists(object)) return false;
        if (!checkIfClubNameExists(object)) return false;
        if (!checkIfTypeExists(object)) return false;
        if (!checkIfPlayerExists(object)) return false;
        if (!checkIfPlayerPositionExists(object)) return false;
        return true;
    }

    boolean checkIfGameLineupIdExists(String[] object) {
        if (object[0].isBlank() || object[0].isEmpty()) {
            System.out.print("ERROR: sastavi_utakmice nema utakmicaID: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfClubNameExists(String[] object) {
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.print("ERROR: sastavi_utakmice nema naziv kluba: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfTypeExists(String[] object) {
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.print("ERROR: sastavi_utakmice nema vrstu: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfPlayerExists(String[] object) {
        if (object[3].isBlank() || object[3].isEmpty()) {
            System.out.print("ERROR: sastavi_utakmice nema igrača: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfPlayerPositionExists(String[] object) {
        if (object[4].isBlank() || object[4].isEmpty()) {
            System.out.print("ERROR: sastavi_utakmice nema poziciju: ");
            printData(object);
            return false;
        }
        return true;
    }
}
