package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChoseContentWindow {

    WebDriver driver;

    public ChoseContentWindow(WebDriver driver){
        this.driver=driver;
    }

    By addFromComputerBtn = By.xpath("/html/body/div[8]/div[2]/div/div/div/div[2]/div[1]/div/div/div[2]/div/button");
    public By getAddFromComputerBtn() {
        return addFromComputerBtn;
    }

    public void clickBtnAddFromComputer(){
        driver.findElement(addFromComputerBtn).click();
    }



}
