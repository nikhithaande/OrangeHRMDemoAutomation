package Tests;


import PageObjects.PODashboard;
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

public class TestLogin extends base {
    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;
    String url;
    @BeforeTest
    public void setUp() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialised");
        url = prop.getProperty("url");
    }

    @Test(dataProvider="data")
    public void testLogin(String userName, String password) throws IOException, InterruptedException {
        driver.get(url);
        log.info("Navigated to homePage");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        POLoginPage lp = new POLoginPage(driver);
//        lp.userName().sendKeys(lp.userString());
//        lp.password().sendKeys(lp.passwordString());
        lp.userName().sendKeys(userName);
        lp.password().sendKeys(password);
        PODashboard db = lp.loginBtn();
        log.info("Login successful");
        Thread.sleep(2000);

        String actualText = db.dashBoardText().getText();
        String expectedText = "Dashboard";
        Assert.assertEquals(expectedText,actualText);
        //Screenshot
//        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(src, new File("target/screenShot.png"));
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]{{"Admin","admin123"}};
    }
}
