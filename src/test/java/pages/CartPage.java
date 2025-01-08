package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    public void productAddedToTheCart() {
        $x("//*[@id='cart_title']").shouldBe(Condition.visible);
        $x("//a[text()='Navy Cotton T-Shirt']").shouldBe(Condition.visible);
    }
}
