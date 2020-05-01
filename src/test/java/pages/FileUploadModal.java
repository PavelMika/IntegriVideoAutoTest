package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadModal extends BasePage {

    public FileUploadModal(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void dragAndDropClick(){
        driver.findElement(By.cssSelector(".integri-chat-manual-upload.integri-pointer")).click();
    }

    public void uploadElement(){
        driver.findElement(By.cssSelector("[accept='*']")).sendKeys(System.getProperty("user.dir")+"/src/main/resources/File1.txt");
    }

    public void uploadElements(){
        driver.findElement(By.cssSelector("[accept='*']")).sendKeys(System.getProperty("user.dir")+"/src/main/resources/File1.txt");
        driver.findElement(By.cssSelector("[accept='*']")).sendKeys(System.getProperty("user.dir")+"/src/main/resources/File2.txt");
    }
    public void startClick(){
        driver.findElement(By.cssSelector(".integri-file-upload-start.integri-float-right.integri-button-blue")).click();
    }
}
