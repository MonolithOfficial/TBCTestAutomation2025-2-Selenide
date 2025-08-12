package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class FileUploadPage {
    public SelenideElement fileInput = $(byId("file-upload"));
    public SelenideElement submitButton = $(byId("file-submit"));
}
