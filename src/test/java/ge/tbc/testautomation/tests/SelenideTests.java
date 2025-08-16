package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.steps.theinternet.DynamicControlsSteps;
import ge.tbc.testautomation.util.RetryAnalyzer;
import ge.tbc.testautomation.util.RetryCount;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.util.CustomCondition.textOfLength;

//@Test(groups = {"Selenide 1"})
public class SelenideTests extends BaseTest {
    DynamicControlsSteps dynamicControlsSteps;

    @BeforeClass
    public void setUp(){
        Configuration.timeout = 10000;
        dynamicControlsSteps = new DynamicControlsSteps();
    }

    // this is a demonstation test case for selenide and it is not real in any way
    @Test(retryAnalyzer = RetryAnalyzer.class)
    @RetryCount(count = 2)
    public void testLocators() {
        open("https://the-internet.herokuapp.com/dynamic_controls");

        dynamicControlsSteps
                .clickEnableButton()
                .fillInputWhenEnabled(Constants.MESSAGE)
                .clickDisableButton()
                .validateAllButtonTexts("Remove")
                .validateHeader(Constants.HEADER_TEXT);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, groups = {"Selenide 1"})
    @RetryCount(count = 5)
    public void testCustomCondition() {
        open("https://swoop.ge");
        SelenideElement annualSavings = $(byText("წლიური დანაზოგი")).$x(".//following-sibling::p");
        annualSavings.scrollTo().shouldHave(textOfLength(10)); // will fail
    }
}
