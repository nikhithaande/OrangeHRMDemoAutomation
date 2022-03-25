package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class base {
    WebDriver driver;
    public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        String path = "/Users/nande/eclipse-workspace/SeleniumOrangeHRMDemo/src/main/java/Resources/data.properties";
        prop = new Properties();
        FileInputStream fis = new FileInputStream(path);
        prop.load(fis);

        String browser = prop.getProperty("browser");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/nande/Downloads/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenShotFilePath = System.getProperty("user.dir")+"/target/Sshots/" +testCaseName+".png";
        FileUtils.copyFile(src, new File(screenShotFilePath));
        return screenShotFilePath;
    }
}
