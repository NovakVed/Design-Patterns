package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.club.Club;

public class LoadClub extends LoadData {
    public LoadClub() {
    }

    @Override
    void storeFileData(String fileData) {
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            Club club = new Club(objectData[0], objectData[1], objectData[2]);
            if (StoredFileObjects.clubs.contains(club))
                System.out.println("ERROR: klub je već postoji");
            StoredFileObjects.clubs.add(club);
        }
    }

    @Override
    boolean checkObjectData(String[] object) {
        if (object.length != 3) {
            System.out.printf("ERROR: klub %10s nema potpune podataka%n", object[1]);
            return false;
        }
        return true;
    }
}
