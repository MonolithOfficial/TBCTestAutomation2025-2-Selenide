package ge.tbc.testautomation.steps.theinternet;

import ge.tbc.testautomation.pages.theinternet.FileUploadPage;

import java.io.File;

public class FileUploadSteps {
    FileUploadPage fileUploadPage = new FileUploadPage();

    public FileUploadSteps uploadFile(File file){
        fileUploadPage.fileInput.uploadFile(file);

        return this;
    }

    public FileUploadSteps submitFile(){
        fileUploadPage.submitButton.click();

        return this;
    }
}
