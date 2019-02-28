import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Slide implements ISlide {

    //Properties
    private ArrayList<IImage> images = new ArrayList<>();
    private ArrayList<String> tags = new ArrayList<>();
    private int imageAmount;
    private ISlide next;

    //Constructors
    public Slide(){
        this.next = null;
    }

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
        int avgTagLength = 0;
        int sum = 0;
        Set<Integer> keys = tagAmountToSlides.keySet();
        for(Integer key:keys){
            sum += key;
        }
        avgTagLength = sum/keys.size();

        if(tagAmountToSlides.containsKey(avgTagLength)){
            return tagAmountToSlides.get(avgTagLength).get(0);
        }
        else {
            boolean tagNotFound = true;
            int i = 1;
            Integer tagLen = avgTagLength;
            while (tagNotFound){
                if(tagAmountToSlides.containsKey(tagLen + i)){
                    tagNotFound = false;
                } else if(tagAmountToSlides.containsKey(tagLen - i))
                    i++;
            }
            return tagAmountToSlides.get(tagLen).get(0);
        }
    }
    public void addTags(List<String> tags){
        for(String tag: tags){
            if(!this.tags.contains(tag)){
                this.tags.add(tag);
            }
        }
    }
    public void addImage(IImage image){
        images.add(image);
    }
    public boolean equals(ISlide slide){
        boolean foundImg = false;
        for(IImage imgThis: this.images){
            for (IImage imgOther:slide.getImages()){
                if(imgThis.getId() == imgOther.getId()) {
                    foundImg = true;
                    break;
                }
            }
            if(!foundImg){
                return false;
            }
        }
        return true;
    }
    public int getAmountOfJointTags(ISlide slide){
        int jointTagsCount = 0;
        for(String tag:this.tags){
            if(slide.getTags().contains(tag)){
                jointTagsCount++;
            }
        }
        return jointTagsCount;
    }
}