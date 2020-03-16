package tests;

import org.testng.annotations.Test;
import tests.BaseTest;

public class SettingsTest extends BaseTest {

    @Test
    public  void changeName(){
        settingsModal.openPage();
        settingsModal.clickSettingButton();
        settingsModal.editName("Baby Yoda");
    }

    @Test
    public void addEmail(){
        settingsModal.openPage();
        settingsModal.clickSettingButton();
        settingsModal.newEmail("rusak@gmail.com");
    }

    @Test
    public void addUrl(){
        settingsModal.openPage();
        settingsModal.clickSettingButton();
        settingsModal.newUrl("https://www.odnoklassniki.ru");
    }
}
