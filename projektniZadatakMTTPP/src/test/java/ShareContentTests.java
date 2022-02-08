import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;


public class ShareContentTests {

    public WebDriver driver;

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
            styleDataPage=new StyleDataWindow(driver);
            detailsPage=new DetailsWindow(driver);
            chooseDataPage=new ChoseContentWindow(driver);
            uploadPage=new UploadWindow(driver);
    }

    public String testURL = "https://www.instagram.com";
    private static String path;
    Browser browser=new Browser();
    LogInPage logIn;
    ComputerAddDataWindow computerAddDataWindow=new ComputerAddDataWindow();
    HomePage homePage;
    StyleDataWindow styleDataPage;
    DetailsWindow detailsPage;
    ChoseContentWindow chooseDataPage;
    WebDriverWait wait;
    UploadWindow uploadPage;
    AcceptCookiesWindow acceptCookiesWindow;
    String directory="user.dir";
    String picture1="\\luna.jpg", picture2="\\perunika.jpg", video="\\preluk.mp4";
    String shareConfirmation="Objava je podijeljena";


    public void addPicture(String picture){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getShareFunctionalityBtn()));
        homePage.clickBtnShareFunctionality();
        wait.until(ExpectedConditions.presenceOfElementLocated(chooseDataPage.getAddFromComputerBtn()));
        chooseDataPage.clickBtnAddFromComputer();
        path= System.getProperty(directory)+picture;
        computerAddDataWindow.chooseAndAddPictureOrVideo(path);
    }

    public void addVideo(String video){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getShareFunctionalityBtn()));
        homePage.clickBtnShareFunctionality();
        wait.until(ExpectedConditions.presenceOfElementLocated(chooseDataPage.getAddFromComputerBtn()));
        chooseDataPage.clickBtnAddFromComputer();
        path=System.getProperty(directory)+video;
        computerAddDataWindow.chooseAndAddPictureOrVideo(path);
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getNextBtn()));
    }
    public void addTwoPictures(){
        wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getShareFunctionalityBtn()));
        addPicture(picture1);
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getOpenFeatureAddMoreDataBtn()));
        styleDataPage.clickBtnOpenFeatureAddMoreData();
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getAddMoreDataBtn()));
        styleDataPage.clickBtnAddMoreData();
        path=System.getProperty(directory)+picture2;
        computerAddDataWindow.chooseAndAddPictureOrVideo(path);
    }
    public void share() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getNextBtn()));
        Thread.sleep(1000);
        styleDataPage.clickBtnNext();
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getNextBtn()));
        Thread.sleep(1000);
        styleDataPage.clickBtnNext();
        wait.until(ExpectedConditions.presenceOfElementLocated(detailsPage.getShareBtn()));
        Thread.sleep(1000);
        detailsPage.clickBtnShare();
    }

   @Test(priority = 0)
    public void shareImage() throws InterruptedException {
        addPicture(picture1);
        share();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(uploadPage.getSharedCaption(), uploadPage.getSharedCaptionElement().getText() ));
        Assert.assertEquals(uploadPage.getTextSharedCaption(), shareConfirmation);
    }
   @Test(priority = 2)
    public void shareVideo() throws InterruptedException {
        addVideo(video);
        share();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(uploadPage.getSharedCaption(), uploadPage.getSharedCaptionElement().getText() ));
        Assert.assertEquals(uploadPage.getTextSharedCaption(), shareConfirmation);
    }

    @Test(priority = 1)
    public void shareTwoPictures() throws InterruptedException {
        addTwoPictures();
        wait.until(ExpectedConditions.presenceOfElementLocated(styleDataPage.getArrowNextRightBtn()));
        share();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(uploadPage.getSharedCaption(), uploadPage.getSharedCaptionElement().getText() ));
        Assert.assertEquals(uploadPage.getTextSharedCaption(), shareConfirmation);
    }

    @AfterMethod
    public void teardownTest() {
        driver.quit();
    }
}
