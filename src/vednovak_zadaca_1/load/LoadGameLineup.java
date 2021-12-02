package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.championship.GameLineup;

public class LoadGameLineup extends LoadData {
    public LoadGameLineup() {
    }

    @Override
    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            GameLineup gameLineup = new GameLineup(Integer.parseInt(objectData[0]),
                    objectData[1], objectData[2], objectData[3], objectData[4]);
            if (StoredFileObjects.gameLineups.contains(gameLineup))
                System.out.println("ERROR: sastav utakmice već postoji");
            StoredFileObjects.gameLineups.add(gameLineup);
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
