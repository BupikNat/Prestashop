package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class TShirtsPage {
    private final String
            ADD_TO_CART_BUTTON = "li:has(a[title='Navy Cotton T-Shirt']) .ajax_add_to_cart_button",
            CART = "div.shopping_cart b",
            ORDER_BUTTON = "[title='Оформить заказ']",
            PRODUCT1 = "a.product-name[title='Navy Cotton T-Shirt']";

    @Step("")
    public void addProductToTheCart() {
        $(PRODUCT1).scrollTo().hover();
        $(ADD_TO_CART_BUTTON).shouldBe(Condition.visible);
        $(ADD_TO_CART_BUTTON).click();
    }

}