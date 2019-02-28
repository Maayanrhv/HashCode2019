import java.util.ArrayList;
import java.util.List;

/**
 * Created by djoff on 28/02/2019.
 */
public class Solution {
    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        LoadData.LoadData(data, "inputFile.in");
        
        DoSomething(data);
        
        System.out.println("hi");
    }
}
