package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import ge.tbc.testautomation.pages.DynamicControlsPage;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.screenshot;

public class DynamicControlsSteps {
    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    public DynamicControlsSteps clickEnableButton(){
        dynamicControlsPage.enableButton.click();

        return this;
    }

    public DynamicControlsSteps fillInputWhenEnabled(String message){
        dynamicControlsPage.input.shouldBe(Condition.enabled).sendKeys(message);

        return this;
    }

    public DynamicControlsSteps clickDisableButton(){
        dynamicControlsPage.disableButton.click();
        dynamicControlsPage.input.shouldNot(Condition.enabled);
//        dynamicControlsPage.input.shouldBe(Condition.disabled);

        return this;
    }

    public DynamicControlsSteps validateAllButtonTexts(String text){
        dynamicControlsPage.allButtons.shouldHave(CollectionCondition.itemWithText(text), CollectionCondition.allMatch("textMatch", e -> e.getText().contains("m")));

        screenshot("name.png");
        return this;
    }

    public DynamicControlsSteps validateHeader(String expectedText){
        ElementsCollection allHeaders = dynamicControlsPage.exampleDiv.$$(byTagName("h4"));
        allHeaders.shouldHave(CollectionCondition.itemWithText(expectedText));

        return this;
    }
}
