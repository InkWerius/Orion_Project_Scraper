import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.Collections;

public class ItemRequest implements Runnable {

    private Thread thread;
    private Source source;

    public ItemRequest(Source source) {
        this.source = source;
        thread = new Thread(this);
    }

    public void requestFromSource() {

        if (this.source.getUrl() == "") {
            return;
        }

        Browser browser = new Browser();
        HtmlPage htmlPage;

        try {
            browser.getWebClient().getPage(this.source.getUrl());
            browser.getWebClient().waitForBackgroundJavaScript(10_000);
            htmlPage = (HtmlPage) browser.getWebClient().getCurrentWindow().getEnclosedPage();
        } catch (Exception e) {
            System.out.println("We didnt get the page");
            htmlPage = null;
        } finally {
            browser.getWebClient().close();
        }
        //how to create new Item and add it to Source list
        if (htmlPage != null) {
            this.source.htmlElementList = htmlPage.getByXPath(this.source.getElementXPath()); //add Xpath
            System.out.println("We got " + this.source.htmlElementList.size() + " elements from Source");
        } else {
            return;
        }


        /* This should be changed later
        * Now it works as a Citi_link Store API
        * */
        if (this.source.htmlElementList.isEmpty()) {
            System.out.println("We did not get items, make new request");
        } else {
            for(HtmlElement he : this.source.htmlElementList){
                //Item Name
                String itemName = ((HtmlElement) he.getFirstByXPath(this.source.getTitleXPath())).getFirstChild().getNodeValue();

                //Item Price
                String itemPrice = ((HtmlElement) he.getFirstByXPath(this.source.getPriceXPath()))
                        .getFirstChild()
                        .getNodeValue()
                        .replace(" ", "")
                        .replace("\n", "");
                int itemIntPrice = Integer.parseInt(itemPrice);

                //Item URL
                String url = "https://www.citilink.ru/" + ((HtmlElement) he.getFirstByXPath(this.source.getUrlXPath())).getAttribute("href");

                Item item = new Item(itemName, url, itemIntPrice);
                this.source.itemList.add(item);
            }

            Collections.sort(this.source.itemList);
            for(Item item : this.source.itemList){
                System.out.println(item);
            }

        }
    }

    //fabric method
    public static ItemRequest createAndStart(Source source) {
        ItemRequest itemRequest = new ItemRequest(source);
        itemRequest.thread.start();
        return itemRequest;
    }

    public Source getSource() {
        return source;
    }

    @Override
    public void run() {
        requestFromSource();
    }
}
