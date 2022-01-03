package vednovak_zadaca_3.load;

import vednovak_zadaca_3.data.championship.Match;

class LoadMatch extends LoadData {
    LoadMatch() {
    }

    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            Match match = new Match(Integer.parseInt(objectData[0]),
                    Integer.parseInt(objectData[1]), objectData[2], objectData[3], objectData[4]);
            if (LoadFileStoredData.matches.contains(match))
                System.out.println("ERROR: utakmica već postoji");
            LoadFileStoredData.matches.add(match);
        }
    }

    boolean checkObjectData(String[] object) {
        return checkMatchData(object);
    }

    boolean checkMatchData(String[] object) {
        if (object.length != 5) {
            if (object.length == 4 && (!object[0].isBlank() || !object[1].isBlank()
                    || !object[2].isBlank() || !object[3].isBlank())) {
                System.out.print("ERROR: utakmica nema vrijeme početka: ");
                printData(object);
            } else {
                System.out.printf("ERROR: utakmica nema sve podatake%n");
            }
            return false;
        }
        if (!checkIfMatchIdExists(object)) return false;
        if (!checkIfMatchRoundExists(object)) return false;
        if (!checkIfHomeTeamExists(object)) return false;
        if (!checkIfAwayTeamExists(object)) return false;
        if (!checkIfMatchStartExists(object)) return false;
        return true;
    }

    private boolean checkIfMatchIdExists(String[] object) {
        if (object[0].isBlank() || object[0].isEmpty()) {
            System.out.print("ERROR: utakmica nema utakmicaID: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfMatchRoundExists(String[] object) {
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.print("ERROR: utakmica nema broj kola: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfHomeTeamExists(String[] object) {
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.print("ERROR: utakmica nema domaćina: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfAwayTeamExists(String[] object) {
        if (object[3].isBlank() || object[3].isEmpty()) {
            System.out.print("ERROR: utakmica nema gosta: ");
            printData(object);
            return false;
        }
        return true;
    }

    private boolean checkIfMatchStartExists(String[] object) {
        if (object[4].isBlank() || object[4].isEmpty()) {
            System.out.print("ERROR: utakmica nema vrijeme početka: ");
            printData(object);
            return false;
        }
        return true;
    }
}
