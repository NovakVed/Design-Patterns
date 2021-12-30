package vednovak_zadaca_1.load;

import vednovak_zadaca_1.data.championship.Event;

class LoadEvent extends LoadData {
    LoadEvent() {
    }

    void storeFileData(String fileData) {
        Event event = null;
        String[] objectData = fileData.split(";");
        if (checkObjectData(objectData)) {
            int eventType = Integer.parseInt(objectData[2]);
            if (eventType == 0 || eventType == 99)
                event = loadEventGameStatus(objectData);
            if (eventType >= 1 && eventType <= 3)
                event = loadEventGoalStatus(objectData);
            if (eventType == 10 || eventType == 11)
                event = loadEventCardStatus(objectData);
            if (eventType == 20)
                event = loadEventSubstitution(objectData);
            if (event != null)
                LoadFileStoredData.events.add(event);
        }
    }

    Event loadEventGameStatus(String[] objectData) {
        return new Event.EventBuilder(Integer.parseInt(objectData[0]),
                objectData[1], objectData[2]).build();
    }

    Event loadEventGoalStatus(String[] objectData) {
        return new Event.EventBuilder(Integer.parseInt(objectData[0]),
                objectData[1], objectData[2])
                .setClubID(objectData[3])
                .setPlayer(objectData[4]).build();
    }

    Event loadEventCardStatus(String[] objectData) {
        return new Event.EventBuilder(Integer.parseInt(objectData[0]),
                objectData[1], objectData[2])
                .setClubID(objectData[3])
                .setPlayer(objectData[4]).build();
    }

    Event loadEventSubstitution(String[] objectData) {
        return new Event.EventBuilder(Integer.parseInt(objectData[0]),
                objectData[1], objectData[2])
                .setClubID(objectData[3])
                .setPlayer(objectData[4])
                .setSubstitute(objectData[5])
                .build();
    }

    //TODO ubaci provjere
    boolean checkObjectData(String[] object) {
        if (object.length < 3) {
            System.out.println("ERROR: događaj nema potpune podataka");
            return false;
        }
        return true;
    }
}
