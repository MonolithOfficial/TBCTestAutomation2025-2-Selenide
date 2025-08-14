package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.steps.FileDownloadSteps;
import ge.tbc.testautomation.steps.FileUploadSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browserType"})
    public void setUp(String browserType){
        if (browserType.equals("chrome")){
            driver = new ChromeDriver();
            WebDriverRunner.setWebDriver(driver);
        } else if (browserType.equals("firefox")) {
            driver = new FirefoxDriver();
            WebDriverRunner.setWebDriver(driver);
        }
        else {
            driver = new EdgeDriver();
            WebDriverRunner.setWebDriver(driver);
        }
        Configuration.timeout = 10000;
    }
}
