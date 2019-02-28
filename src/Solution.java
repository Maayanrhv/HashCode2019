import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by djoff on 28/02/2019.
 */
public class Solution {
    public static void main(String[] args) {
        LoadData ld = new LoadData();
        List<ISlide> slides = ld.load("a_example.txt");
        int sAmount = slides.size();
        Map<Integer, List<ISlide>> slidesMapTags =  ld.getTagAmountToSlides();
        ISlide start = Solution.startSlide(slidesMapTags);
        GreedySlidesSearch algo = new GreedySlidesSearch(slides, start);


        DumpData dd = new DumpData();
        dd.PrintOutput(algo.getSlidesPath(), sAmount );

    }

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

}
