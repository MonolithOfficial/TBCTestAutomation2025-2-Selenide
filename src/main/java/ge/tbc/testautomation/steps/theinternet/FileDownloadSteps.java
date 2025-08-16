package ge.tbc.testautomation.steps.theinternet;

import ge.tbc.testautomation.pages.theinternet.FileDownloadPage;

import java.io.File;

public class FileDownloadSteps {
    FileDownloadPage fileDownloadPage = new FileDownloadPage();

    public File downloadFile(){
        return fileDownloadPage.catImageDownloadLink.download();
    }
}
