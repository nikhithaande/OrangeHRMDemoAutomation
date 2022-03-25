package Tests;

import PageObjects.POLoginPage;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestValidateText extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    WebDriver driver;
    @BeforeTest
    public void setUp() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialised");
        String url = prop.getProperty("url");
        driver.get(url);
        log.info("Navigated to homePage");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }
    @Test
    public void validateText() {
        POLoginPage lp = new POLoginPage(driver);
        String actualText = lp.panelText1().getText();
        log.info(actualText);
        String expectedText = "LOGIN Panel";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test(dependsOnMethods={"validateText"})
    public void validateForgotPasswordText() {
        POLoginPage lp = new POLoginPage(driver);
        String actualText = lp.forgotPasswordText().getText();
        log.info(actualText);
        String expectedText = "Forgot your password?";
        Assert.assertEquals(expectedText,actualText);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
