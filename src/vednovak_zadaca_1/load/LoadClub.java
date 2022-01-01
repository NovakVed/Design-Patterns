package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.club.Club;

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
                System.out.printf("ERROR: klub %10s nema trenera%n", object[1]);
            } else {
                System.out.printf("ERROR: klub nema sve podatake%n");
            }
            return false;
        }
        if (object[0].isBlank() || object[0].isEmpty()) {
            System.out.printf("ERROR: klub %10s nema klubID%n", object[1]);
            return false;
        }
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.printf("ERROR: klub nema naziv kluba%n");
            return false;
        }
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.printf("ERROR: klub %10s nema trenera%n", object[1]);
            return false;
        }
        return true;
    }
}
