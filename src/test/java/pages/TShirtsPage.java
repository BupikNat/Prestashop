package pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TShirtsPage {
    private final String
            ADD_TO_CART_BUTTON = "li:has(a[title='Navy Cotton T-Shirt']) .ajax_add_to_cart_button",
            CART = "div.shopping_cart b",
            ORDER_BUTTON = "[title='Оформить заказ']",
            PRODUCT1 = "a.product-name[title='Navy Cotton T-Shirt']";

    public void openTShirtsPage() {
        $(PRODUCT1).scrollTo().hover();
        $(ADD_TO_CART_BUTTON).shouldBe(Condition.visible);
        $(ADD_TO_CART_BUTTON).click();
    }

    public void checkProductIsAddedToCart() {
        $(CART).scrollIntoView(true).click();
    }
}