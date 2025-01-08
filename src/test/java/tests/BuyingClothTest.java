package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Test
public class BuyingClothTest extends BaseTest {

   public void loginUser () {
       loginPage.openPage();
       loginPage.clickOnLoginButton();
       loginPage.login("lerodev772@chansd.com", "qwert1234");
       myAccountPage.openTShortsPage();
       tShirtsPage.openTShirtsPage();
       tShirtsPage.checkProductIsAddedToCart();
       cartPage.productAddedToTheCart();
   }
}
