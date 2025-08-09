package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.DynamicControlsSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {
    DynamicControlsSteps dynamicControlsSteps;
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        Configuration.browser = "chrome"; // driver = new ChromeDriver();
        Configuration.timeout = 10000;
//        Configuration.browserSize = "1920x1080";
        dynamicControlsSteps = new DynamicControlsSteps();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    // this is a demonstation test case for selenide and it is not real in any way
    @Test
    public void testLocators() {
        open("https://the-internet.herokuapp.com/dynamic_controls");

        dynamicControlsSteps
                .clickEnableButton()
                .fillInputWhenEnabled(Constants.MESSAGE)
                .clickDisableButton()
                .validateAllButtonTexts("Remove")
                .validateHeader(Constants.HEADER_TEXT);
    }
}
