package ge.tbc.testautomation.steps.swoop;

import ge.tbc.testautomation.pages.swoop.CategoryPage;
import ge.tbc.testautomation.pages.swoop.CommonPage;

public class CommonSteps {
    CommonPage commonPage = new CommonPage();
    public CommonSteps goToCategory(String category){
        commonPage.getLinkByLabel(category).click();
        return this;
    }

    public CommonSteps exitSummerAlert(){
        commonPage.exitSummerAlertButton.click();

        return this;
    }
}
