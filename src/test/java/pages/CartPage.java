package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CartPage {

    @Step("")
    public void productAddedToTheCart() {
        log.info("Product is added to the Cart");
        $x("//*[@id='cart_title']").shouldBe(Condition.visible);
        $x("//a[text()='Navy Cotton T-Shirt']").shouldBe(Condition.visible);
    }
}
