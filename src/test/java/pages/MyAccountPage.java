package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MyAccountPage {

    private final String WOMEN = "[title='Women']",
            T_SHIRTS = "[title=T-shirts]",
            TSHIRTS_PAGE = "//span[@class='cat-name' and contains(text(),'T-shirts')]";

    public void openTShortsPage() {
        $(WOMEN).hover();
        $(T_SHIRTS).shouldBe(Condition.visible);
        $(T_SHIRTS).click();
        $x(TSHIRTS_PAGE).shouldBe(Condition.visible);
    }
}