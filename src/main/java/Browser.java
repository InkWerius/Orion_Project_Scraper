import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

public class Browser {

   private WebClient webClient;

   public Browser(){
        webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setUseInsecureSSL(false);

        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);

        webClient.getCookieManager().setCookiesEnabled(true);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());

       webClient.getCurrentWindow().setInnerHeight(60000);
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
