package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.data.DataSupplier;
import ge.tbc.testautomation.steps.swoop.CategorySteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DataProviderExampleTest {
    CategorySteps categorySteps;
    @BeforeClass
    public void setUp(){
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";

        categorySteps = new CategorySteps();

        open("https://swoop.ge/");
        categorySteps.exitSummerAlert();
    }

    @Test(dataProviderClass = DataSupplier.class, dataProvider = "SwoopDataProvider")
    public void testSwoopCategoryLabels(String category, String expectedLabelText) {
        categorySteps.goToCategory(category);

        if (category.equals("კინო")){
            categorySteps.validateFilmPageLabel(expectedLabelText);
        }
        else {
            categorySteps.validatePageLabel(expectedLabelText);
        }
    }
}
