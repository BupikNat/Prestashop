package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class CreateAccountPage {

    private final String USER_MAIL = "[id='email_create']",
            BUTTON_CREATE_ACCOUNT = "[id='SubmitCreate']";

    @Step("Создать новый аккаунт с уже использованным адресом почты {user}")
    public void createAccountWithBeforeUsedEmail(String user) {
        log.info("Create new account with before used email '{}'", user);
        $(USER_MAIL).setValue(user);
        $(BUTTON_CREATE_ACCOUNT).click();
        $("#create_account_error").shouldBe(Condition.visible);
    }

    @Step("Создать новый аккаунт с почтой {user_email}")
    public void createAccount(String user_email) {
        log.info("Create new account with user_email '{}'", user_email);
        $(USER_MAIL).setValue(user_email);
        $(BUTTON_CREATE_ACCOUNT).click();
        $(byText("Your personal information")).shouldBe(Condition.visible);
    }
}