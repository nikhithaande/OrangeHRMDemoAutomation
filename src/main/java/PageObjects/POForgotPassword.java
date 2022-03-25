package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POForgotPassword {
    WebDriver driver;

    public POForgotPassword(WebDriver driver2){
        this.driver = driver2;
    }

    By userName = By.id("securityAuthentication_userName");
    By reset = By.id("btnSearchValues");

    public WebElement userEmail(){
        return driver.findElement(userName);
    }
    public WebElement resetBtn(){
        return driver.findElement(reset);
    }
}
