package tests;

import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ChatTests extends BaseTest {

    @Test
    public void sendMessage() {
        chatPage.openPage();
        chatPage.writeText("Test");
        chatPage.clickSend();
        chatPage.messageShouldExist(1,"Text");
    }

    @Test
    public void sendMessageByButton(){
        chatPage.openPage();
        chatPage.writeText("Test2");
        chatPage.clickByButton();
        chatPage.messageShouldExist(1,"Text2");
    }

    @Test
    public void sendLinc(){
        String someLink = "onliner.by";
        chatPage.openPage();
        chatPage.writeText(someLink);
        chatPage.clickByButton();
        chatPage.messageShouldExist(1,someLink);
    }

     @Test
     public void sendHtmlCod (){
         String htmlCod = "<html><body><p>test</p></body></html>";
         chatPage.openPage();
         chatPage.writeText(htmlCod);
         chatPage.clickByButton();
         chatPage.messageShouldExist(1,"test");
     }

     @Test
     public void sendThousendSymbol(){
         String longMessage = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.  Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit";
         chatPage.openPage();
         chatPage.writeText(longMessage);
         chatPage.clickByButton();
         chatPage.messageShouldExist(1,longMessage);
     }

     @Test
     public void editMessage() {
         chatPage.openPage();
         chatPage.writeText("Text");
         chatPage.clickSend();
         chatPage.clickEditButton();
         chatPage.editMessage("New text");
         chatPage.editMessageShouldExist(1,"New text");
     }

     @Test
     public void deleteMessage() {
         chatPage.openPage();
         chatPage.writeText("Text");
         chatPage.clickSend();
         chatPage.clickEditButton();
         chatPage.deleteMessage();
         chatPage.findErrorMessage();
     }

     @Test
     public void deleteMessageByButton() {
         chatPage.openPage();
         chatPage.writeText("Text");
         chatPage.clickSend();
         chatPage.clickDeleteButton();
         chatPage.removeMessageShouldExist(1,"removed...");
     }

     @Test
     public void sendElevenMessages(){
         chatPage.openPage();
         chatPage.elevenMessages("Text",11);
         chatPage.checkError();
     }

     @Test
     public void checkInviteButton(){
         chatPage.openPage();
         chatPage.clickInviteButton();
         chatPage.checkUrl();
     }

    @Test
    public void checkСodeCopy(){
        chatPage.openPage();
        chatPage.clickLink();
        chatPage.checkCode();
    }
}
