package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.championship.Match;

class LoadMatch extends LoadData {
    LoadMatch() {
    }

    @Override
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

    @Override
    boolean checkObjectData(String[] object) {
        if (object.length != 5) {
            System.out.printf("ERROR: utakmica ID: %10s nema potpune podataka%n", object[0]);
            return false;
        }
        return true;
    }
}
