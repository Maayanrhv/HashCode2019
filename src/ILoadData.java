import java.util.List;
import java.util.Map;

/**
 * Created by djoff on 28/02/2019.
 */
public interface ILoadData {
    List<ISlide> load(String fileName);
    Map<Integer, List<ISlide>> getTagAmountToSlides();

}
