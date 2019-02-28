import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoadData {

    /**
     * LoadData reads lines from a file to a List<String>.
     * @param data - the List<String>. 
     * @param fileName - the path to the file that holds the data
     */
    static void LoadData(List<String> data, String fileName) {
        BufferedReader reader = null; 
        try {
            // read the first line as a String
            reader = new BufferedReader(new FileReader(new File(fileName)));
            String firstLine = reader.readLine();

            // go over all the records and add them to the records list 
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}