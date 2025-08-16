package ge.tbc.testautomation.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CategoryPage extends CommonPage{
    public SelenideElement pageLabel = $x("//h3[@type='h3']");
    public ElementsCollection filmButtons = $$x("//nav//following::button[@data-testid='tertiary-button']//p");
}
