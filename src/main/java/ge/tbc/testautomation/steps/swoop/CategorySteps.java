package ge.tbc.testautomation.steps.swoop;

import ge.tbc.testautomation.pages.swoop.CategoryPage;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;

public class CategorySteps extends CommonSteps{
    CategoryPage categoryPage = new CategoryPage();

    public CategorySteps validatePageLabel(String expectedLabelText){
        categoryPage.pageLabel.shouldHave(text(expectedLabelText));

        return this;
    }

    public CategorySteps validateFilmPageLabel(String expectedLabelText){
        categoryPage.filmButtons.shouldHave(itemWithText(expectedLabelText));

        return this;
    }
}
