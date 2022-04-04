import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Main;

public class ScraperDemo {
    public static void main(String[] args) throws InterruptedException {

        SourceManager sourceManager = new SourceManager();

        //pretend this is different Sources
        sourceManager.addSource("https://www.citilink.ru/search/?text=iphone+13");
        sourceManager.addSource("https://www.citilink.ru/search/?text=rtx+3060&menu_id=29");

        for (int i = 0; i < sourceManager.sourceList.size(); i++) {
            sourceManager.sourceList.get(i).setElementXPath("//div[@class='product_data__gtm-js product_data__pageevents-js  ProductCardVertical js--ProductCardInListing ProductCardVertical_normal ProductCardVertical_shadow-hover ProductCardVertical_separated']");
            sourceManager.sourceList.get(i).setTitleXPath("./div/div/div[3]/div/a");
            sourceManager.sourceList.get(i).setPriceXPath("./div/div[2]/div[1]/div/div/div[2]/span/span[1]");
            sourceManager.sourceList.get(i).setUrlXPath("./a");
        }
        sourceManager.updateAll();
    }
}
