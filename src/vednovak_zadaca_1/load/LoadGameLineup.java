package vednovak_zadaca_1.load;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.GameLineup;

class LoadGameLineup extends LoadData {
    LoadGameLineup(String fileName) {
        readFileData(fileName);
    }

    @Override
    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            GameLineup gameLineup = new GameLineup(Integer.parseInt(objectData[0]),
                    objectData[1], objectData[2], objectData[3], objectData[4]);
            if (StoredData.gameLineups.contains(gameLineup))
                System.out.println("ERROR: sastav utakmice već postoji");
            StoredData.gameLineups.add(gameLineup);
        }
    }

    @Override
    boolean checkObjectData(String[] object) {
        if (object.length != 5) {
            System.out.printf("ERROR: sastav utakmice ID: %10s nema potpune podataka%n", object[0]);
            return false;
        }
        return true;
    }
}
