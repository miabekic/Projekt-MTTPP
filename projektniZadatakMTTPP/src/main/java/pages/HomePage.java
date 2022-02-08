package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    By shareFunctionalityBtn=By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[3]/div/button");
    By searchTab=By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/input");
    By firstFind=By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/a");

    public By getFirstFind() {
        return firstFind;
    }

    public By getSearchTab() {
        return searchTab;
    }

    public By getShareFunctionalityBtn() {
        return shareFunctionalityBtn;
    }
    public void clickBtnShareFunctionality(){
        driver.findElement(shareFunctionalityBtn).click();
    }
    public void enterSearchUsername(String username){
        driver.findElement(searchTab).sendKeys(username);
    }
    public void clickFirstFind(){
        driver.findElement(firstFind).click();
    }
}
