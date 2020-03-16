package tests;

import org.testng.annotations.Test;

public class FileUploadModalTest extends BaseTest {

    @Test
    public void uploadFile(){
        fileUploadModal.openPage();
        fileUploadModal.dragAndDropClick();
        fileUploadModal.uploadElement();
        fileUploadModal.startClick();
    }

    @Test
    public void uploadFiles(){
        fileUploadModal.openPage();
        fileUploadModal.dragAndDropClick();
        fileUploadModal.uploadElements();
        fileUploadModal.startClick();
    }
}
