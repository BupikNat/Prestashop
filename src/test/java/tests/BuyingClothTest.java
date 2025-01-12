package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Test
@Log4j2
public class BuyingClothTest extends BaseTest {

   @Test(testName = "Login user", description = "Check login", retryAnalyzer = Retry.class)
   @Description("Log in user")
   public void loginUser () {
       loginPage.openPage();
       loginPage.clickOnLoginButton();
       loginPage.login("lerodev772@chansd.com", "qwert1234");
       myAccountPage.openTShortsPage();
       tShirtsPage.addProductToTheCart();
       //cartPage.productAddedToTheCart();
   }
}
