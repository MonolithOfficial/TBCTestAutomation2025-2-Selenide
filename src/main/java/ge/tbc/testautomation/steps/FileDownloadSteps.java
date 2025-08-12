package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.FileDownloadPage;

import java.io.File;

public class FileDownloadSteps {
    FileDownloadPage fileDownloadPage = new FileDownloadPage();

    public File downloadFile(){
        return fileDownloadPage.catImageDownloadLink.download();
    }
}
