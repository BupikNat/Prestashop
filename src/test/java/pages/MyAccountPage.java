package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class MyAccountPage {

    private final String WOMEN = "[title='Women']",
            T_SHIRTS = "[title='T-shirts']",
            TSHIRTS_PAGE = "//span[@class='cat-name' and contains(text(),'T-shirts')]";

    @Step("")
    public void openTShortsPage() {
        log.info("Open T-Shirts page");
        $(WOMEN).hover();
        $(T_SHIRTS).shouldBe(Condition.visible);
        $(T_SHIRTS).click();
        $x(TSHIRTS_PAGE).shouldBe(Condition.visible);
    }
}