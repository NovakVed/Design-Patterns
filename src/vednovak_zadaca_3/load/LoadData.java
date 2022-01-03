package vednovak_zadaca_3.load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

abstract class LoadData {
    void readFileData(String fileName) {
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine(); //skips first line
            while ((line = bufferedReader.readLine()) != null) {
                storeFileData(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void storeFileData(String fileData) {
        throw new UnsupportedOperationException();
    }

    boolean checkObjectData(String[] object) {
        throw new UnsupportedOperationException();
    }

    void printData(String[] object) {
        if (object.length != 0) {
            for (String o:object) {
                System.out.printf("%s ", o);
            }
            System.out.printf("%n");
        }
    }
}
