package ge.tbc.testautomation.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTestClass {
    private String language;

    public ParametrizedTestClass(String language) {
        this.language = language;
    }

    @BeforeClass
    public void setUp(){
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.pageLoadTimeout = 10;
        open("https://swoop.ge/");
    }

    @Test
    public void testLanguage(){
        System.out.println(language);
    }
}
