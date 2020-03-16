package pages;

import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ChatPage extends BasePage {

    public ChatPage(WebDriver driver) {
        super(driver);
    }
    public void openPage(){
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void writeText(String text) {
        driver.findElement(By.cssSelector("textarea")).sendKeys(text);
    }

    public void clickSend(){
        driver.findElement(By.cssSelector(".integri-chat-send-message")).click();
    }

    public void clickByButton(){
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-paper-plane")).click();
    }

    public void clickEditButton(){
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-pencil.integri-chat-edit-message")).click();
    }

    public void clickDeleteButton(){
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-trash2.integri-chat-remove-message")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Are you sure to delete message?", alertText);
        driver.switchTo().alert().accept();
    }

    public void editMessage(String text){
        driver.findElement(By.cssSelector("textarea")).clear();
        driver.findElement(By.cssSelector("textarea")).sendKeys(text);
        driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ENTER);
    }

    public void deleteMessage(){
        driver.findElement(By.cssSelector("textarea")).clear();
        driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ENTER);
    }

    public void messageShouldExist(int messageIndex, String text){
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex -1).getText().equals(text);
        assertTrue("Message does not exist", isExist);
    }

    public void editMessageShouldExist(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex-1).getText().equals(text);
        assertTrue("Message does not exist", isExist);
    }

    public  void findErrorMessage(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElements(By.cssSelector(".integri-notify-error"));
    }

    public void removeMessageShouldExist(int messageIndex, String text) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text"));
        boolean isExist = messages.get(messageIndex-1).getText().equals(text);
        assertTrue("Message does not exist", isExist);
    }

    public void elevenMessages(String text, int number){
        for (int i=1; i<=number;i++){
            driver.findElement(By.cssSelector("textarea")).sendKeys(text);
            driver.findElement(By.cssSelector(".integri-chat-send-message")).click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkError(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector(".integri-button.big-button"));
    }

    public void clickInviteButton(){
        driver.findElement(By.id("invite-users-to-chat")).click();
    }

    public void checkUrl(){
        String bufferLink = driver.getCurrentUrl();
        String getLink = null;
        try {
        getLink = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        String bufferUrl = driver.getCurrentUrl();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(bufferLink,getLink);
    }

    public void clickLink(){
        driver.findElement(By.cssSelector(".component-code")).click();
    }

    public void checkCode(){
        String bufferCode = driver.findElement(By.cssSelector(".component-code")).getText();
        String getCode = null;
        try {
        getCode = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
