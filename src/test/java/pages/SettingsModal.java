package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;

public class SettingsModal extends BasePage{

    public SettingsModal(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void clickSettingButton(){
        driver.findElement(By.cssSelector(".integri-chat-settings.integri-pointer")).click();
    }

    public void editName(String userName){
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys(userName);
        driver.findElement(By.name("userName")).sendKeys(Keys.ENTER);
        String IsExist = driver.findElement(By.name("userName")).getAttribute("value");
        assertEquals(IsExist,userName);
    }

    public void newEmail(String userEmail){
        driver.findElement(By.name("userEmail")).sendKeys(userEmail);
        driver.findElement(By.name("userEmail")).sendKeys(Keys.ENTER);
        String IsExist = driver.findElement(By.name("userEmail")).getAttribute("value");
        assertEquals(IsExist,userEmail);
    }

    public void newUrl(String photoUrl) {
        driver.findElement(By.name("userPic")).sendKeys(photoUrl);
        driver.findElement(By.name("userPic")).sendKeys(Keys.ENTER);
        String IsExist = driver.findElement(By.name("userPic")).getAttribute("value");
        assertEquals(IsExist, photoUrl);
    }
}
