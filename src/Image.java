import java.util.List;


public class Image implements IImage {
    private List<String> tags;
    public List<String> getTags() {
        return tags;
    }
    public void addTag(String tag) {
        this.tags.add(tag);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTagsAmount() {
        return tagsAmount;
    }
    public void setTagsAmount(int tagsAmount) {
        this.tagsAmount = tagsAmount;
    }
    public Orientation getOrient() {
        return orient;
    }
    public void setOrient(char c) {
        if (c == 'H')
            this.orient = Orientation.H;
        else
            this.orient = Orientation.V;
    }
    private int id;
    private int tagsAmount;

    
}
