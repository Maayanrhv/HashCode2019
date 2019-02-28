import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Slide implements ISlide {

    //Properties
    private ArrayList<IImage> images = new ArrayList<>();
    private ArrayList<String> tags = new ArrayList<>();
    private int imageAmount;
    private ISlide next;

    //Constructors
    public Slide(){ }

    //Getters & Setters
    public void setImages(ArrayList<IImage> value){
        this.images = value;
    }
    public void setTags(ArrayList<String> value){
        this.tags = value;
    }
    public void setImageAmount(int value){
        this.imageAmount = value;
    }
    public void setNext(ISlide value){
        this.next = value;
    }

    public ArrayList<IImage> getImages(){
        return images;
    }
    public ArrayList<String> getTags(){
        return tags;
    }
    public int getImageAmount(){
        return imageAmount;
    }
    public ISlide getNext(){
        return next;
    }

    //Methods
    public static ISlide startSlide(Map<Integer, List<ISlide>> tagAmountToSlides){
        return null;
    }
    public void addTags(ArrayList<String> tags){
        for(String tag: tags){
            if(!this.tags.contains(tag)){
                this.tags.add(tag);
            }
        }
    }
    public void addImage(IImage image){
        images.add(image);
    }
}