package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CommonPage {
    public SelenideElement getLinkByLabel(String label){
        return $x(String.format("//img[@alt='%s']", label));
    }

    public SelenideElement exitSummerAlertButton = $x("//img[@alt='summer']//following-sibling::button");
}
