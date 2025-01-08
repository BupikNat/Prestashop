package pages;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final String USER = "[name=email]",
            PASSWORD = "[name=passwd]",
            BUTTON_SIGN_IN = "[id=SubmitLogin]";

    public void openPage() {
        open("/ru");
        $(byTitle("Войти в учетную запись покупателя")).shouldBe(Condition.visible);
    }

    public void clickOnLoginButton() {
        $(byText("Войти")).click();
        $(byText("Authentication")).shouldBe(Condition.visible);
    }

    public void login(String user, String password) {
        $(USER).setValue(user);
        $(PASSWORD).setValue(password);
        $(BUTTON_SIGN_IN).click();
        $(byText("My account")).shouldBe(Condition.visible);
    }
}
