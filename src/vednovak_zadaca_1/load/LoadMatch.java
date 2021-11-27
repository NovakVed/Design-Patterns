package vednovak_zadaca_1.load;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Match;

class LoadMatch extends LoadData {
    LoadMatch(String fileName) {
        readFileData(fileName);
    }

    @Override
    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            Match match = new Match(Integer.parseInt(objectData[0]),
                    Integer.parseInt(objectData[1]), objectData[2], objectData[3], objectData[4]);
            if (StoredData.matches.contains(match)) System.out.println("ERROR: utakmica već postoji");
            StoredData.matches.add(match);
        }
    }

    //TODO provjeri ovo za igrače bla bla
    @Override
    boolean checkObjectData(String[] object) {
        if (object.length != 5) {
            System.out.printf("ERROR: utakmica ID: %10s nema potpune podataka%n", object[0]);
            return false;
        }
        return true;
    }
}
