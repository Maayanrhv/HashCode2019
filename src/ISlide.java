import java.util.ArrayList;
import java.util.List;

public interface ISlide {
    //Getters & Setters
    void setImages(ArrayList<IImage> value);
    void setTags(ArrayList<String> value);
    void setImageAmount(int value);
    void setNext(ISlide value);

    ArrayList<IImage> getImages();
    ArrayList<String> getTags();
    int getImageAmount();
    ISlide getNext();
    void addTags(List<String> tags);

    //Methods
    void addImage(IImage image);
    int getAmountOfJointTags(ISlide slide);

}