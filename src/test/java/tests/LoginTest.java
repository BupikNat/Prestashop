package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

   @Test(testName = "Login user", description = "Check login")
   @Description("Log in user")
   public void loginUser () {
       loginPage.openPage(baseUrl);
       loginPage.clickOnLoginButton();
       loginPage.login(user, password);
   }
}