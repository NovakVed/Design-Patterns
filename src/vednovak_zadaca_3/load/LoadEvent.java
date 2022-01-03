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
                if (checkIfClubExists(objectData) && checkIfPlayerExists(objectData))
                    event = loadEventGoalStatus(objectData);
            if (eventType == 10 || eventType == 11)
                if (checkIfClubExists(objectData) && checkIfPlayerExists(objectData))
                    event = loadEventCardStatus(objectData);
            if (eventType == 20)
                if (checkIfClubExists(objectData) && checkIfPlayerExists(objectData)
                        && checkIfPlayerSubstitutionExists(objectData))
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

    boolean checkObjectData(String[] object) {
        return checkEventData(object);
    }

    boolean checkEventData(String[] object) {
        if (object.length < 3) {
            if (object.length == 0) System.out.printf("ERROR: događaj nema podataka%n");
            else {
                System.out.print("ERROR: događaj nema sve podataka: ");
                printData(object);
            }
            return false;
        }
        if (!checkIfGameIdExists(object)) return false;
        if (!checkIfMinuteExists(object)) return false;
        if (!checkIfTypeExists(object)) return false;
        return true;
    }

    boolean checkIfGameIdExists(String[] object) {
        if (object[0].isBlank() || object[0].isEmpty()) {
            System.out.print("ERROR: događaj: nema utakmicaID: ");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkIfMinuteExists(String[] object) {
        if (object[1].isBlank() || object[1].isEmpty()) {
            System.out.print("ERROR: događaj: nema minutu: ");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkIfTypeExists(String[] object) {
        if (object[2].isBlank() || object[2].isEmpty()) {
            System.out.print("ERROR: događaj: nema vrstu: ");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkIfClubExists(String[] object) {
        if (object[3].isBlank() || object[3].isEmpty()) {
            System.out.print("ERROR: događaj: nema klub: ");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkIfPlayerExists(String[] object) {
        if (object.length < 5 || object[4].isBlank() || object[4].isEmpty()) {
            System.out.print("ERROR: događaj: nema igrača");
            printData(object);
            return false;
        }
        return true;
    }

    boolean checkIfPlayerSubstitutionExists(String[] object) {
        if (object.length != 6 || object[5].isBlank() || object[5].isEmpty()) {
            System.out.print("ERROR: događaj: nema zamjenskog igrača: ");
            printData(object);
            return false;
        }
        return true;
    }
}
