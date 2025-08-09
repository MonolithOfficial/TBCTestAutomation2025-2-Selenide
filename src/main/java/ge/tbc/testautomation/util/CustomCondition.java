package ge.tbc.testautomation.util;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebElementCondition;
import org.openqa.selenium.WebElement;

public class CustomCondition {
    public static WebElementCondition textOfLength(int expectedLength) {
        return new WebElementCondition("text of length " + expectedLength) {
            @Override
            public CheckResult check(Driver driver, WebElement webElement) {
                String text = webElement.getText();
                return new CheckResult(text.length() == expectedLength, "length(\"" + text + "\") = " + text.length());
            }
        };
    }
}
