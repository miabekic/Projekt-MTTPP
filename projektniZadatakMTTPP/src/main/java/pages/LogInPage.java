package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver=driver;
    }

    By button=By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button");
    By usernameTextBox=By.name("username");
    By passwordTextBox=By.name("password");
    By errorText=By.id("slfErrorAlert");


    public By getErrorText() {
        return errorText;
    }

    public void clickButton(){
        driver.findElement(button).click();
    }
    public void enterUsername(String username){
        driver.findElement(usernameTextBox).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public String getTextErrorText(){
      return  driver.findElement(errorText).getText();
    }

    public void logIn(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickButton();
    }
}
