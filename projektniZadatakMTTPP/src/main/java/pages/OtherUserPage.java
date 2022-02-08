package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OtherUserPage {

    WebDriver driver;

    public OtherUserPage(WebDriver driver){
        this.driver=driver;
    }

    By followBtn=By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[1]/div[1]/div/div/button");

    public By getFollowBtn() {
        return followBtn;
    }

    public void clickFollowBtn(){
        driver.findElement(followBtn).click();
    }

    public String getFollowBtnText(){
        return driver.findElement(followBtn).getText();
    }
}
