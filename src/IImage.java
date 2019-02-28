import java.util.List;

/**
 * Created by djoff on 28/02/2019.
 */
public interface IImage {

    List<String> getTags();
    public void addTag(String tag);
    public int getId();
    public void setId(int id);
    public int getTagsAmount();
    public void setTagsAmount(int tagsAmount);
    public Orientation getOrient();
    public void setOrient(char c);
}
