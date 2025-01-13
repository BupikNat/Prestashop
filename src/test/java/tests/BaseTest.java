package tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestListener;
import org.testng.annotations.*;
import pages.CartPage;
import pages.LoginPage;
import org.testng.asserts.SoftAssert;
import pages.MyAccountPage;
import pages.TShirtsPage;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import utils.ScreenshotUtil;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest {

    LoginPage loginPage;
    MyAccountPage myAccountPage;
    TShirtsPage tShirtsPage;
    CartPage cartPage;

    @Parameters({"browser"})
    @BeforeMethod
    @Description("Открытие браузера")
    public void setup(@Optional("firefox") String browser) {
        if(browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            Configuration.browserCapabilities = options;
            Configuration.browser = "firefox";
            Configuration.browserSize = "1920x1080";
            Configuration.headless = false;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl = "http://prestashop.qatestlab.com.ua/ru/";
            Configuration.reportsFolder = "target/allure-results";
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            options.addArguments("--allow-insecure-localhost");
            options.addArguments("--disable-web-security");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://prestashop.qatestlab.com.ua/ru/");
            Configuration.browserCapabilities = options;
            Configuration.browser = "chrome";
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl = "http://prestashop.qatestlab.com.ua/ru/";
            Configuration.reportsFolder = "target/allure-results";
        }

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
    @Description("Закрытие браузера")
    public void close() {
        ScreenshotUtil.attachScreenshot("Screenshot before closing the browser");
        closeWebDriver();
    }
}

