import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by djoff on 28/02/2019.
 */
public class GreedySlidesSearch {
    private Set<ISlide> slides;
    private ISlide start;

    public GreedySlidesSearch(List<ISlide> slides, ISlide start) {
        this.slides = new HashSet<ISlide>(slides);
        this.start = start;
        // TODO: need to be .equal?
        this.slides.remove(start);
    }

    public ISlide getSlidesPath(){
        HashSet<ISlide> slides = new HashSet<>(this.slides);

        ISlide currentSlide = this.start;
        while (!slides.isEmpty()) {
            ISlide next = this.findBestNextSlide(slides, currentSlide);
            currentSlide.setNext(next);




        }


        return null;
    }

    public ISlide findBestNextSlide(HashSet<ISlide> slides, ISlide currentSlide) {

        return null;
    }


}
