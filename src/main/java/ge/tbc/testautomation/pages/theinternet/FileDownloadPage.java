package ge.tbc.testautomation.pages.theinternet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class FileDownloadPage {
    public SelenideElement catImageDownloadLink = $(withTagAndText("a", "kote.jpg"));
}
