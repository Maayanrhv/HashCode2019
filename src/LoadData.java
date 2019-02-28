import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadData {

    /**
     * LoadData reads lines from a file to a List<String>.
     * @param data - the List<String>. 
     * @param fileName - the path to the file that holds the data
     */
    static List<Slide> LoadData(String fileName) {
        BufferedReader reader = null; 
        try {
            // read the first line as a String
            reader = new BufferedReader(new FileReader(new File(fileName)));
            String firstLine = reader.readLine();
            int numOfPictures = Integer.parseInt(firstLine);
            List<Slide> slides = new ArrayList<Slide>();
            
            // go over all the records and add them to the records list 
            for (int i = 0; i < numOfPictures; i++) {
                Image image = new Image();
                String[] line = reader.readLine().split(" ");
                image.setId(i);
                image.setOrient(line[0].charAt(0));
                image.setTagsAmount(Integer.parseInt(line[1]));
                for (int j = 0; j < image.getTagsAmount(); j++) {
                    image.addTag(line[1+j]);
                }
                
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