package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PODashboard {
    WebDriver driver;
    public PODashboard(WebDriver driver2){
        this.driver = driver2;
    }

    By text = By.cssSelector("#content h1");

    public WebElement dashBoardText(){
        return driver.findElement(text);
    }
}
