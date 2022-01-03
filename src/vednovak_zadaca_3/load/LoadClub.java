package vednovak_zadaca_3.load;

import vednovak_zadaca_3.data.club.Club;

class LoadClub extends LoadData {
    LoadClub() {
    }

    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            Club club = new Club(objectData[0], objectData[1], objectData[2]);
            if (LoadFileStoredData.clubs.contains(club))
                System.out.println("ERROR: klub je već postoji");
            LoadFileStoredData.clubs.add(club);
        }
    }

    boolean checkObjectData(String[] object) {
        return checkPlayerData(object);
    }

    boolean checkPlayerData(String[] object) {
        if (object.length != 3) {
            if (object.length == 2 && (!object[0].isBlank() || !object[1].isBlank())) {
                System.out.print("ERROR: klub nema trenera: ");
                printData(object);
            } else {
                System.out.printf("ERROR: klub nema podatake%n");
            }
            return false;
        }
        if (!checkIfClubIdExists(object)) return false;
        if (!checkIfClubNameExists(object)) return false;
        if (!checkIfCoachExists(object)) return false;
        return true;
    }

    boolean checkIfClubIdExists (String[] object) {
        if (object[0].isBlank() || object[0].isEmpty()) {
            System.out.print("ERROR: klub nema klubID: ");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkIfClubNameExists(String[] object) {
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.print("ERROR: klub nema naziv kluba: ");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkIfCoachExists(String[] object) {
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.print("ERROR: klub nema trenera: ");
            printData(object);
            return false;
        }
        return true;
    }
}
