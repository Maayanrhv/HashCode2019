import java.time.chrono.IsoChronology;
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
        slides.remove(currentSlide);


        while (!slides.isEmpty()) {
            ISlide next = this.findBestNextSlide(slides, currentSlide);
            currentSlide.setNext(next);
            currentSlide = next;
            slides.remove(next);
        }
        return this.start;
    }

    public ISlide findBestNextSlide(HashSet<ISlide> slides, ISlide currentSlide) {
        int maxPayoff = -1;
        ISlide next = slides.iterator().next();
        for (ISlide slide: slides) {
            int payoff = this.calculatePayoff(currentSlide, slide);
            if (payoff > maxPayoff) {
                next = slide;
                maxPayoff = payoff;
            }
            // if equals to max - take the one with most tags
            else if (payoff == maxPayoff) {
                if (slide.getTags().size() > next.getTags().size()) {
                    next = slide;
                    maxPayoff = payoff;
                }
            }
        }
        return next;
    }

    // TODO: slides amount for shir
    public int calculatePayoff(ISlide sl1, ISlide sl2) {
        // by definition
        int intersectionAmount = sl1.getAmountOfJointTags(sl2);
        // no slides with one tag
        if (intersectionAmount == 1 || intersectionAmount == 0) {
            return intersectionAmount;
        }
        if (intersectionAmount == sl1.getTags().size() || intersectionAmount == sl2.getTags().size()) {
            return 0;
        }
        return Math.min(sl1.getTags().size() - intersectionAmount, sl2.getTags().size() - intersectionAmount);
    }


}
