package Tests;

import PageObjects.PODashboard;
import PageObjects.POForgotPassword;
import PageObjects.POLoginPage;
import org.testng.Assert;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.time.Duration;

public class TestValidateForgotPasswordLink extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    WebDriver driver;
    @BeforeTest
    public void setup() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialised");
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
    @Test
    public void validateForgotPasswordLink() {
        try {
            POLoginPage lp1 = new POLoginPage(driver);
            lp1.forgotPassLink().click();
            POForgotPassword fp1 = new POForgotPassword(driver);
            fp1.userEmail().sendKeys("abc@gmail.com");
            fp1.resetBtn().click();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @BeforeTest
    public void tearDown(){
        driver.close();
    }

}
