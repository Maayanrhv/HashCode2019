import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadData implements ILoadData{

    private boolean vFlag;
    private ISlide vetricals;
    private Map<Integer, List<ISlide>> tagsToSlides;
    
    public LoadData() {
        this.vFlag = false;
        this.tagsToSlides = new HashMap<Integer, List<ISlide>>();
    }
    
    /**
     * LoadData reads lines from a file to a List<String>.
     * @param data - the List<String>. 
     * @param fileName - the path to the file that holds the data
     */
    public List<ISlide> load(String fileName) {
        BufferedReader reader = null; 
        try {
            // read the first line as a String
            reader = new BufferedReader(new FileReader(new File(fileName)));
            String firstLine = reader.readLine();
            int numOfPictures = Integer.parseInt(firstLine);
            List<ISlide> slides = new ArrayList<ISlide>();
            
            // go over all the images and create them 
            for (int i = 0; i < numOfPictures; i++) {
                String[] line = reader.readLine().split(" ");
                IImage image = CreateImage(line, i);
                ISlide slide = new Slide();

                // address vertical images
                if (image.getOrient() == Orientation.V) {
                    if (vFlag == false) {
                        this.vetricals = slide;
                        this.vetricals.setImageAmount(2);
                        this.vFlag = true;
                    } else {
                        this.vFlag = false;
                    }
                // address horizontal images
                } else {
                    slide.setImageAmount(1);
                }
                slide.addTags(image.getTags());
                slides.add(slide);
                // enter to map
                
            }
            return new ArrayList<ISlide>();
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

    @Override
    public Map<Integer, List<ISlide>> getTagAmountToSlides() {
        // TODO Auto-generated method stub
        return null;
    }
}