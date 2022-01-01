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

    boolean checkObjectData(String[] object) {
        return checkIfPlayerHasAllInfo(object);
    }

    boolean checkIfPlayerHasAllInfo(String[] object) {
        if (object.length != 4) {
            if (object.length == 3
                    && (!object[0].isBlank() || !object[1].isBlank() || !object[2].isBlank())) {
                System.out.printf("ERROR: igrač %10s nema datum rođenja%n", object[1]);
            } else {
                System.out.printf("ERROR: igrač nema sve podatake%n");
            }
            return false;
        }
        if (object[0].isBlank() || object[0].isEmpty()) {
            System.out.printf("ERROR: igrač %10s nema klub%n", object[1]);
            return false;
        }
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.printf("ERROR: igrač nema imena%n");
            return false;
        }
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.printf("ERROR: igrač %10s nema poziciju%n", object[1]);
            return false;
        }
        if (object[3].isBlank() || object[3].isEmpty()) {
            System.out.printf("ERROR: igrač %10s nema datum rođenja%n", object[1]);
            return false;
        }
        return true;
    }
}
