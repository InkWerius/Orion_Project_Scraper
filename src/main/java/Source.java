import com.gargoylesoftware.htmlunit.html.HtmlElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Source implements Serializable {
    private String url;
    public List<Item> itemList = new ArrayList<>();
    public List<HtmlElement> htmlElementList = new ArrayList<>();

    private String elementXPath;
    private String titleXPath;
    private String priceXPath;
    private String urlXPath;

    public Source(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getElementXPath() {
        return elementXPath;
    }

    public void setElementXPath(String elementXPath) {
        this.elementXPath = elementXPath;
    }

    public String getTitleXPath() {
        return titleXPath;
    }

    public void setTitleXPath(String titleXPath) {
        this.titleXPath = titleXPath;
    }

    public String getPriceXPath() {
        return priceXPath;
    }

    public void setPriceXPath(String priceXPath) {
        this.priceXPath = priceXPath;
    }

    public String getUrlXPath() {
        return urlXPath;
    }

    public void setUrlXPath(String urlXPath) {
        this.urlXPath = urlXPath;
    }
}
