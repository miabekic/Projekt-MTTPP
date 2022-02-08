package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AcceptCookiesWindow {

    WebDriver driver;

    By acceptBtn=By.xpath("/html/body/div[4]/div/div/button[1]");
    public AcceptCookiesWindow(WebDriver driver){
        this.driver=driver;
    }

    public By getAcceptBtn() {
        return acceptBtn;
    }

    public void clickAcceptBtn(){
        driver.findElement(acceptBtn).click();
    }

}
