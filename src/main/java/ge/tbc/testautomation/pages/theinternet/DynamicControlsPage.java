package ge.tbc.testautomation.pages.theinternet;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DynamicControlsPage {
    public SelenideElement enableButton = $(by("onclick", "swapInput()"));
    public SelenideElement input = $(by("type", "text"));
    public SelenideElement disableButton = $x("//button[@onclick='swapInput()' and text()='Disable']");
    public SelenideElement exampleDiv = $x("//div[@class='example']");
    public ElementsCollection allButtons = $$(byTagName("button"));
//    public SelenideElement input = $(byXpath("//input[@type, 'text']"));
}
