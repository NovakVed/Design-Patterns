package vednovak_zadaca_1.load;

import vednovak_zadaca_1.StoredData;
import vednovak_zadaca_1.data.Player;

class LoadPlayer extends LoadData {
    LoadPlayer(String fileName) {
        readFileData(fileName);
    }

    @Override
    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            Player player = new Player(objectData[0], objectData[1], objectData[2], objectData[3]);
            if (StoredData.players.contains(player)) System.out.println("ERROR: igrač već postoji");
            StoredData.players.add(player);
        }
    }

    @Override
    boolean checkObjectData(String[] object) {
        if (object.length != 4) {
            System.out.printf("ERROR: igrac: %10s nema podataka%n", object[1]);
            return false;
        }
        return true;
    }
}
