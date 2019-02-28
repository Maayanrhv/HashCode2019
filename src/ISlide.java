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

    //Methods
    void addTags(List<String> tags);
    void addImage(IImage image);
    boolean equals(ISlide slide);
    int getAmountOfJointTags(ISlide slide);
}