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

    //TODO ubaci provjere igraca
    boolean checkObjectData(String[] object) {
        if (object.length != 4) {
            System.out.printf("ERROR: igrač %10s nema podataka%n", object[1]);
            return false;
        }
        return true;
    }
}
