import java.math.BigDecimal;
import java.util.Comparator;

public class Item implements Comparable<Item> {

    private String title;
    private String url;
    private int price;  //Change to BigDecimal later

    public Item() {
    }

    public Item(String title, String url, int price) {
        this.title = title;
        this.url = url;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item {" +
                "Title='" + title + '\'' +
                ", Price='" + price + "'\n" +
                " Link='" + url + '\'' +
                '}' + "\n";
    }

    @Override
    public int compareTo(Item o) {
        return this.getPrice()-o.getPrice();
    }
}
