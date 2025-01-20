package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import models.PersonalInfo;
import org.testng.annotations.Test;
import pages.PersonalInfoPage;
import models.PersonalInfo;

@Test
public class CreateAccountTest extends BaseTest{

    Faker faker = new Faker();

    PersonalInfo validAccount = PersonalInfo.builder()
            .first_name(faker.name().firstName())
            .last_name(faker.name().lastName())
            .new_password(faker.internet().password(8, 16))
            .build();

    PersonalInfo notValidAccount = PersonalInfo.builder()
            .first_name(faker.name().firstName())
            .new_password(faker.internet().password(8, 16))
            .build();

    @Test(testName = "Create Account", description = "Check creation of new account")
    @Description("Create Account")
    public void loginUser () {
        loginPage.openPage(baseUrl);
        loginPage.clickOnLoginButton();
        createAccountPage.createAccountWithBeforeUsedEmail(user);
        createAccountPage.createAccount(faker.internet().emailAddress());
        personalInfoPage.addNotEnoughPersonalInformation(notValidAccount);
        personalInfoPage.addPersonalInformation(validAccount);
        loginPage.clickOnLogOutButton();
    }
}