import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DumpData {
    public void PrintOutput(ISlide root, int slidesAmount) {
        BufferedWriter writer = null;
        try {
            // write the output
            writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(GetOutput(root, slidesAmount));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String GetOutput(ISlide root, int slidesAmount) {
        // start with the number of slides
        StringBuilder builder = new StringBuilder();
        builder.append(slidesAmount + "\n");
        ISlide current = root;
        // go over the slides
        while (current != null) {
            // add slide's id
            if (current.getImageAmount() == 1)
                builder.append(current.getImages().get(0).getId() + "\n");
            else {
                builder.append(current.getImages().get(0).getId() +" "+ current.getImages().get(0).getId() + "\n");
            }
            current = current.getNext();
        }
        return builder.toString();
    }
}
