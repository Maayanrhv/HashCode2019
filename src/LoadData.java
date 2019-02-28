import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadData implements ILoadData{

    private boolean vFlag;
    
    /**
     * LoadData reads lines from a file to a List<String>.
     * @param data - the List<String>. 
     * @param fileName - the path to the file that holds the data
     */
    public List<Slide> load(String fileName) {
        BufferedReader reader = null; 
        try {
            // read the first line as a String
            reader = new BufferedReader(new FileReader(new File(fileName)));
            String firstLine = reader.readLine();
            int numOfPictures = Integer.parseInt(firstLine);
            List<Slide> slides = new ArrayList<Slide>();
            
            // go over all the images and create them 
            for (int i = 0; i < numOfPictures; i++) {
                String[] line = reader.readLine().split(" ");
                IImage image = CreateImage(line, i);
                
                
            }
            return new ArrayList<Slide>();
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
        return null;
    }
    
    public IImage CreateImage(String[] line, int id) {
        IImage image = new Image();
        image.setId(id);
        image.setOrient(line[0].charAt(0));
        image.setTagsAmount(Integer.parseInt(line[1]));
        for (int j = 0; j < image.getTagsAmount(); j++) {
            image.addTag(line[1+j]);
        }
        return image;
    }
}