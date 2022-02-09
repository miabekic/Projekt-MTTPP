package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StyleDataWindow {

    WebDriver driver;

    public StyleDataWindow(WebDriver driver) {
        this.driver=driver;
    }

    By nextBtn=By.xpath("/html/body/div[6]/div[2]/div/div/div/div[1]/div/div/div[2]/div/button");
    By addMoreDataBtn=By.xpath("/html/body/div[6]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div[3]/div/div[1]/div/div/div/div[2]/div/div");
    By openFeatureAddMoreDataBtn=By.xpath("/html/body/div[6]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div[3]/div/div[2]/div/button");
    By arrowNextRightBtn=By.xpath("/html/body/div[6]/div[2]/div/div/div/div[2]/div[1]/div/div/div/span/div[1]/div/button");
    By contentPicture =By.xpath("/html/body/div[6]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div[4]/div/div[1]");
    By contentVideo =By.xpath("/html/body/div[6]/div[2]/div/div/div/div[2]/div[1]/div/div/div/div[3]/div/div[1]/video");
    By exitBtn =By.xpath("/html/body/div[6]/div[1]/button");

    public void clickBtnNext(){
        driver.findElement(nextBtn).click();
    }

    public By getAddMoreDataBtn() {
        return addMoreDataBtn;
    }

    public By getArrowNextRightBtn() {
        return arrowNextRightBtn;
    }

    public By getContentPicture() {
        return contentPicture;
    }

    public By getContentVideo() {
        return contentVideo;
    }

    public By getExitBtn() {
        return exitBtn;
    }

    public By getOpenFeatureAddMoreDataBtn() {
        return openFeatureAddMoreDataBtn;
    }

    public By getNextBtn() {
        return nextBtn;
    }

    public void clickBtnOpenFeatureAddMoreData(){
        driver.findElement(openFeatureAddMoreDataBtn).click();
    }

    public  void  clickBtnAddMoreData(){
        driver.findElement(addMoreDataBtn).click();
    }
    
    public void clickArrowNextRightBtn(){driver.findElement(arrowNextRightBtn).click();}

    public void clickExitBtn(){
        driver.findElement(exitBtn).click();
    }
    public String  getStyleValuePicture(){
        return driver.findElement(contentPicture).getCssValue("style");
    }
    public WebElement findVideo(){
       return  driver.findElement(contentVideo);
    }
}
