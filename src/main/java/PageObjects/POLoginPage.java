package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POLoginPage {
    WebDriver driver;
    public POLoginPage(WebDriver driver2){
        this.driver = driver2;
    }
//<a href="/index.php/auth/requestPasswordResetCode" xpath="1">Forgot your password?</a>
    By panelText = By.id("logInPanelHeading");
    By forgotPass = By.xpath("//a[text()='Forgot your password?']");
    By user = By.id("txtUsername");
    By pass = By.id("txtPassword");
    By forgotPassword = By.cssSelector("a[href*='requestPasswordResetCode']");
    By usertext = By.xpath("//span[text() = \"( Username : Admin | Password : admin123 )\"]");
    By buttonLogin = By.id("btnLogin");

    public WebElement panelText1(){
        return driver.findElement(panelText);
    }
    public WebElement forgotPasswordText(){
        return driver.findElement(forgotPass);
    }
    public WebElement userName(){
        return driver.findElement(user);
    }
    public WebElement password(){
        return driver.findElement(pass);
    }

    public WebElement forgotPassLink(){
        return driver.findElement(forgotPassword);
    }
    public String userString(){
        String userText = driver.findElement(usertext).getText().split(": ")[1].split(" |")[0];
        return userText;
    }
    public String passwordString(){
        String passwordText = driver.findElement(usertext).getText().split("| ")[1].split(" :")[0];
        return passwordText;
    }
    public PODashboard loginBtn(){
        driver.findElement(buttonLogin).click();
        PODashboard db =new PODashboard(driver);
        return db;
    }
}
