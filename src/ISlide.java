import java.util.ArrayList;

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
    void addImage(IImage image);
}