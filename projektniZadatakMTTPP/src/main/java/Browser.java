import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    WebDriver driver;

    public WebDriver setupBrowser(String browser){
        if(browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
             driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
             driver=new EdgeDriver();
        }
        return driver;
    }
}
