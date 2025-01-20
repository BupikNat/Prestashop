package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import models.PersonalInfo;

@Log4j2
@Builder
@Data
public class PersonalInfoPage {

    private final String RADIO_BUTTON = "[id='id_gender2']",
    FIRST_NAME = "[id='customer_firstname']",
            LAST_NAME = "[id='customer_lastname']",
            NEW_PASSWORD = "[id='passwd']",
            REGISTER_BUTTON = "[id='submitAccount']";

    public PersonalInfoPage() {
        // Инициализация (если требуется)
    }

    @Step("Заполнить не всю обязательную информацию о новом юзере и нажать кнопку -Зарегистрировать-")
    public void addNotEnoughPersonalInformation(PersonalInfo personalInfo) {
        log.info("Add not all required personal info about new user and try to register");
        $(RADIO_BUTTON).click();
        $(FIRST_NAME).setValue(personalInfo.getFirst_name());
        $(NEW_PASSWORD).setValue(personalInfo.getNew_password());
        $(REGISTER_BUTTON).click();
        $(byText("There is 1 error")).shouldBe(Condition.visible);
    }

    @Step("Заполнить персональную информацию о новом юзере и нажать кнопку -Зарегистрировать-")
    public void addPersonalInformation(PersonalInfo personalInfo) {
        log.info("Add personal info about new user and register");
        $(RADIO_BUTTON).click();
        $(FIRST_NAME).setValue(personalInfo.getFirst_name());
        $(LAST_NAME).setValue(personalInfo.getLast_name());
        $(NEW_PASSWORD).setValue(personalInfo.getNew_password());
        $(REGISTER_BUTTON).click();
        $(byText("My account")).shouldBe(Condition.visible);
    }
}