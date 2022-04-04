import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SourceManager {

    public List<Source> sourceList = new ArrayList<>();
//    public List<Source> resultContainer = new ArrayList<>(); prototype container


    //dev`s method
    public void addSource(String url) {
        Source source = new Source(url);
        sourceList.add(source);
    }

    public void readFromFile() {

    }

    public void updateAll() {
        if (sourceList.isEmpty()) {
            System.out.println("Source list is empty!");
            System.out.println("Add at least one source");
        } else {
            for(Source source : sourceList){
                ItemRequest iRequest = ItemRequest.createAndStart(source);
            }
        }
    }
}
