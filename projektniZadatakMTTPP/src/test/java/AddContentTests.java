
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class AddContentTests

{
    public WebDriver driver;
    public String testURL = "https://www.instagram.com";
    HomePage homePage;
    Browser browser=new Browser();
    ChoseContentWindow chooseDataPage;
    WebDriverWait wait;
    LogInPage logIn;
    ComputerAddDataWindow computerAddDataWindow=new ComputerAddDataWindow();
    StyleDataWindow styleDataPage;
    ConfirmExitWindow confirmExitWindow;
    private static String path;
    AcceptCookiesWindow acceptCookiesWindow;
    String directory="user.dir", styleFunctionalityUrl="https://www.instagram.com/create/style/";
    String picture1="\\Luna.jpg", picture2="\\Perunika.jpg", video="\\Preluk.mp4";

    @BeforeClass
    @Parameters("browser")
    public void setupTests(String browser){
        driver=this.browser.setupBrowser(browser);
        driver.navigate().to(testURL);
        driver.manage().window().maximize();

        homePage=new HomePage(driver);
        chooseDataPage=new ChoseContentWindow(driver);
        logIn=new LogInPage(driver);
        styleDataPage=new StyleDataWindow(driver);
        confirmExitWindow=new ConfirmExitWindow(driver);
        wait=new WebDriverWait(driver, 150);
        acceptCookiesWindow=new AcceptCookiesWindow(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookiesWindow.getAcceptBtn()));
        acceptCookiesWindow.clickAcceptBtn();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookiesWindow.getAcceptBtn()));
        logIn.logIn("testiranje.projekt", "135910157mIa");
    }

     public void addPicture(String picture){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getShareFunctionalityBtn()));
        homePage.clickBtnShareFunctionality();
        wait.until(ExpectedConditions.presenceOfElementLocated(chooseDataPage.getAddFromComputerBtn()));
        chooseDataPage.clickBtnAddFromComputer();
        path= System.getProperty(directory)+picture;
        computerAddDataWindow.chooseAndAddPictureOrVideo(path);
    }

    @Test(priority = 0)
    public void addCorrectPicture(){
        addPicture(picture1);
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getContentPicture()));

        Assert.assertEquals(driver.getCurrentUrl(), styleFunctionalityUrl);
        Assert.assertNotEquals(styleDataPage.getStyleValuePicture().contains("background-image"), true);
    }
    @Test(priority = 1)
    public void addOneMorePicture(){
        addPicture(picture1);
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getOpenFeatureAddMoreDataBtn()));
        styleDataPage.clickBtnOpenFeatureAddMoreData();
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getAddMoreDataBtn()));
        styleDataPage.clickBtnAddMoreData();
        path=System.getProperty(directory)+picture2;
        computerAddDataWindow.chooseAndAddPictureOrVideo(path);
    }

    @Test(priority = 2)
    public void addCorrectVideo(){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getShareFunctionalityBtn()));
        homePage.clickBtnShareFunctionality();
        chooseDataPage.clickBtnAddFromComputer();
        path=System.getProperty(directory)+video;
        computerAddDataWindow.chooseAndAddPictureOrVideo(path);
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getContentVideo()));

        Assert.assertNotEquals(styleDataPage.findVideo(), null);
        Assert.assertEquals(driver.getCurrentUrl(), styleFunctionalityUrl);
    }



    @AfterMethod
    public void exitFromFunctionality() {
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getExitBtn()));
        styleDataPage.clickExitBtn();
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmExitWindow.getContinueBtn()));
        confirmExitWindow.clickContinueBtn();
    }

    @AfterClass
    public void teardownTest() {
        driver.quit();
    }

}
