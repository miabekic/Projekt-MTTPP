import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AcceptCookiesWindow;
import pages.HomePage;
import pages.LogInPage;
import pages.OtherUserPage;

public class FollowTest {

    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setupTests(String browser){
        driver=this.browser.setupBrowser(browser);
        logIn=new LogInPage(driver);
        wait=new WebDriverWait(driver, 150);
        driver.navigate().to(testURL);
        driver.manage().window().maximize();
        acceptCookiesWindow=new AcceptCookiesWindow(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookiesWindow.getAcceptBtn()));
        acceptCookiesWindow.clickAcceptBtn();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookiesWindow.getAcceptBtn()));
        logIn.logIn("testiranje.projekt", "135910157mIa");
        homePage=new HomePage(driver);
        otherUserPage=new OtherUserPage(driver);
    }

    public String testURL = "https://www.instagram.com";
    Browser browser=new Browser();
    LogInPage logIn;
    HomePage homePage;
    WebDriverWait wait;
    OtherUserPage otherUserPage;
    AcceptCookiesWindow acceptCookiesWindow;
    String followUsername="mia.bekic", requestSent="Zahtjev poslan";



    @Test
    public void followPrivateAccount(){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getSearchTab()));
        homePage.enterSearchUsername(followUsername);
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getFirstFind()));
        homePage.clickFirstFind();
        wait.until(ExpectedConditions.presenceOfElementLocated(otherUserPage.getFollowBtn()));
        otherUserPage.clickFollowBtn();
        wait.until(ExpectedConditions.elementToBeClickable(otherUserPage.getFollowBtn()));
        Assert.assertEquals(otherUserPage.getFollowBtnText(), requestSent);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
