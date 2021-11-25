package vednovak_zadaca_1.load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

abstract class LoadData {
    public void readFileData(String fileName) {
        try {
            String line = "";
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

    abstract void storeFileData(String fileData);

    abstract boolean checkObjectData(String[] object);
}
