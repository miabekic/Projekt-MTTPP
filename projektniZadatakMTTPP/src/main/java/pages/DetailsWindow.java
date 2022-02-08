package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsWindow {

    WebDriver driver;

    public DetailsWindow(WebDriver driver){
        this.driver=driver;
    }
    By shareBtn=By.xpath("/html/body/div[6]/div[2]/div/div/div/div[1]/div/div/div[2]/div/button");

    public By getShareBtn() {
        return shareBtn;
    }

    public void clickBtnShare(){
        driver.findElement(shareBtn).click();
    }

}
