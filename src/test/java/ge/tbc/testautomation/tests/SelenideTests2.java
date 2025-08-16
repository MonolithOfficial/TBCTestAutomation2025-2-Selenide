package ge.tbc.testautomation.tests;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.steps.theinternet.FileDownloadSteps;
import ge.tbc.testautomation.steps.theinternet.FileUploadSteps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

@Test(groups = {"Selenide 2"})
public class SelenideTests2 extends BaseTest{
    FileUploadSteps fileUploadSteps;
    FileDownloadSteps fileDownloadSteps;

    @BeforeClass
    public void setUp(){
        Configuration.timeout = 10000;
        fileUploadSteps = new FileUploadSteps();
        fileDownloadSteps = new FileDownloadSteps();
    }

    @Test
    public void testUploadFile() {
        open("https://the-internet.herokuapp.com/upload");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        // C:\Users\Monolith\IdeaProjects\_2025_Selenide_2\src\main\resources\ronaldokneeslide.jpg
        File ronaldoImage = new File("src/main/resources/ronaldokneeslide.jpg");
//        ClassLoader classLoader = this.getClass().getClassLoader();
//        File ronaldoImage = new File(Objects.requireNonNull(classLoader.getResource("ronaldokneeslide.jpg")).getFile());
        fileUploadSteps
                .uploadFile(ronaldoImage)
                .submitFile();

        // assert here
    }

    @Test
    public void testDownload() {
        open("https://the-internet.herokuapp.com/download");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        File downloadedFile = fileDownloadSteps.downloadFile();
        Assert.assertNotNull(downloadedFile);
        Assert.assertEquals(downloadedFile.getName(), "kote.jpg");
//        String fileAbsolutePath = downloadedFile.getAbsolutePath();
    }

    @Test
    public void testFindFilter() {
        open("https://www.telerik.com/support/demos");

        // find (დააკვირდით, რომ find(WebElementCondition condition) მეთოდი წვდომადია ElementsCollection ობიექტებიდან მხოლოდ,
        // პარამეტრად იღებს WebElementCondition-ს, აბრუნებს SelenideElement).
        // როდის ვიყენებთ? - როდესაც გვაქვს კოლექცია და გვინდა იქიდან რამე ერთი ელემენტი ამოვიღოთ რაღაც კონდიციის საფუძველზე.
        SelenideElement navBar = $x("//div[@data-tlrk-plugin='navspy']"); // მოგვაქვს ნავბარი
        SelenideElement desktopLink = navBar
                .$$(byTagName("a")) // მოგვაქვს ყველა ენქორ ტეგი
                .find(Condition.exactText("Desktop")); // ვიღებთ იმ ენქორ ტეგს, რომლის ტექსტი არის ზუსტად 'Desktop'

        // findAll (დააკვირდით, რომ findAll მეთდი წვდომადია SelenideElement ობიექტებიდან მხოლოდ,
        // პარამეტრად იღებს By-ს (რამე ლოკატორს), აბრუნებს ElementsCollection-ს).
        // როდის ვიყენებთ? - როდესაც გვაქვს ერთეულოვანი ვებელემენტი და გვინდა მასში მოვძებნოთ *რამდენიმე* ელემენტი.
        // SelenideElement-საც აქვს find მეთოდი, ოღონდ ის პარამეტრად იღებს By-ს და არა WebElementConditions.
        ElementsCollection anchorLinks = navBar.findAll(byTagName("a")); // ჩათვალეთ, რომ $$ და findAll ერთი და იგივეა.

        // filter (წვდომადია მხოლოდ ElementsCollection-ის ობიექტებიდან მხოლოდ,
        // პარამეტრად იღებს WebElementCondition-ს, აბრუნებს კოლექციას)
        // როდის ვიყენებთ? - როცა გვაქვს კოლექცია და აქედან გვინდა გავფილტროთ ელემენტები რაღაც ქონდიშენის საფუძველზე
        // და ისევ კოლექცია მივიღოთ (გაფილტრული)
        ElementsCollection someKindOfAnchorLinks = navBar.findAll(byTagName("a"))
                .filter(Condition.partialText("p")); // მოგვაქვს ყველა ენქორ ტეგი, რომლის ტექსტიც შეიცავს p-ს.
    }
}
