import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AcceptCookiesWindow;
import pages.HomePage;
import pages.LogInPage;


public class LogInTests {

    public WebDriver driver;
    public String testURL = "http://www.instagram.com";
    public String correctUsername="testiranje.projekt", correctPassword="135910157mIa";
    public String incorrectUsername="testi.ranjemia", incoreectPassword="135910157";
    public String errorIncorrectUsername="Korisničko ime koje ste unijeli ne pripada nijednom računu. Provjerite korisničko ime i pokušajte ponovo.";
    public String errorIncorrectPassword="Nažalost, lozinka je netočna. Molimo, provjerite.";
    public String loggedUrl="https://www.instagram.com/accounts/onetap/?next=%2F";
    public String notLoggedUrl="https://www.instagram.com/";
    Browser browser = new Browser();
    LogInPage logIn;
    WebDriverWait wait;
    AcceptCookiesWindow acceptCookiesWindow;
    HomePage homePage;


    @BeforeMethod
    @Parameters("browser")
            public void setupTests(String browser){
            driver=this.browser.setupBrowser(browser);
            driver.navigate().to(testURL);
            driver.manage().window().maximize();
            wait=new WebDriverWait(driver, 150);
            acceptCookiesWindow=new AcceptCookiesWindow(driver);
            wait.until(ExpectedConditions.presenceOfElementLocated(acceptCookiesWindow.getAcceptBtn()));
            acceptCookiesWindow.clickAcceptBtn();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookiesWindow.getAcceptBtn()));
            logIn=new LogInPage(driver);
            homePage=new HomePage(driver);
    }


        @Test(priority = 0)
        public void wrongUsername(){
            logIn.logIn(incorrectUsername, correctPassword);
            wait.until(ExpectedConditions.presenceOfElementLocated(logIn.getErrorText()));

            Assert.assertEquals(driver.getCurrentUrl(), notLoggedUrl);
            Assert.assertEquals(logIn.getTextErrorText(), errorIncorrectUsername);
           }

        @Test(priority = 1)
            public void wrongPassword(){
            logIn.logIn(correctUsername, incoreectPassword);
            wait.until(ExpectedConditions.presenceOfElementLocated(logIn.getErrorText()));

            Assert.assertEquals(driver.getCurrentUrl(), notLoggedUrl);
            Assert.assertEquals(logIn.getTextErrorText(), errorIncorrectPassword);
            }

        @Test(priority = 2)
            public void correctLogIn(){
               logIn.logIn(correctUsername, correctPassword);
               wait.until(ExpectedConditions.presenceOfElementLocated(homePage.getShareFunctionalityBtn()));
               Assert.assertEquals(driver.getCurrentUrl(), loggedUrl);
    }


         @AfterMethod
            public void teardownTest() {
               driver.quit();
           }
    }

