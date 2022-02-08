package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadWindow {
    WebDriver driver;

    public UploadWindow(WebDriver driver){
        this.driver=driver;
    }
    By sharedCaption=By.xpath("/html/body/div[6]/div[2]/div/div/div/div[1]/div/div/h1");

    public By getSharedCaption() {
        return sharedCaption;
    }

    public String getTextSharedCaption(){
        return driver.findElement(sharedCaption).getText();
    }

    public WebElement getSharedCaptionElement(){
        return driver.findElement(sharedCaption);
    }
}
