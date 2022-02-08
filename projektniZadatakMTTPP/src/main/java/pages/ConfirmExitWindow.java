package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmExitWindow {

    WebDriver driver;

    public ConfirmExitWindow(WebDriver driver){
        this.driver=driver;
    }

    By continueBtn=By.xpath("/html/body/div[9]/div/div/div/div[2]/button[1]");

    public By getContinueBtn() {
        return continueBtn;
    }

    public void clickContinueBtn(){
        driver.findElement(continueBtn).click();
    }


}
