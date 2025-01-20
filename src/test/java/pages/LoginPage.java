package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage {

    private final String USER = "[name=email]",
            PASSWORD = "[name=passwd]",
            BUTTON_SIGN_IN = "[id=SubmitLogin]";

    @Step("Открыть главную страницу Prestashop")
    public void openPage(String baseUrl) {
        log.info("Open page Prestashop");
        open(baseUrl);
        $(".login").shouldBe(Condition.visible);
    }

    @Step("Нажать на кнопку -Войти-")
    public void clickOnLoginButton() {
        log.info("Click on -Login- button");
        $(By.cssSelector(".login")).click();
        $(byText("Authentication")).shouldBe(Condition.visible);
    }

    @Step("Залогиниться под юзером {user} и паролем {password}")
    public void login(String user, String password) {
        log.info("Login into My Account with user '{}' and password '{}'", user, password);
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(BUTTON_SIGN_IN).click();
        $(byText("My account")).shouldBe(Condition.visible);
    }

    @Step("Нажать на кнопку -Выйти-")
    public void clickOnLogOutButton() {
        log.info("Click on -Logout- button");
        $(By.cssSelector(".logout")).click();
        $(byText("Authentication")).shouldBe(Condition.visible);
    }
}