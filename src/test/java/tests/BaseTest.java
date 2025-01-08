package tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import org.testng.asserts.SoftAssert;
import pages.MyAccountPage;
import pages.TShirtsPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    LoginPage loginPage;
    MyAccountPage myAccountPage;
    TShirtsPage tShirtsPage;
    CartPage cartPage;

    @BeforeMethod
    public void setup() {
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--start-maximized");  //можно прописать только через опции Selenium, в Селениде нет
        //options.addArguments("--disable-notifications");
//        options.addArguments("--allow-insecure-localhost");
//        options.addArguments("--disable-web-security");
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://prestashop.qatestlab.com.ua");
        Configuration.browserCapabilities = options;
        Configuration.browser = "firefox";  //Указывается браузер
        Configuration.browserSize = "1920x1080"; // Запуск в полноэкранном режиме
        Configuration.headless = false;  //выключаются заголовки
        Configuration.timeout = 10000;   //тайм аут при открытии страницы
        Configuration.clickViaJs = true;  //взаимодействие с элементами (клики) через JavaScript
        Configuration.baseUrl = "http://prestashop.qatestlab.com.ua";  //базовый url, используется в методе open

        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        tShirtsPage = new TShirtsPage();
        cartPage = new CartPage();


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}