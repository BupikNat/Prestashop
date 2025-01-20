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
import pages.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import utils.PropertyReader;
import utils.ScreenshotUtil;
import pages.PersonalInfoPage;

@Listeners(TestListener.class)
@Log4j2
public class BaseTest {

    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public TShirtsPage tShirtsPage;
    public CartPage cartPage;
    public CreateAccountPage createAccountPage;
    public PersonalInfoPage personalInfoPage;


    protected static String baseUrl = System.getProperty("baseUrl", PropertyReader.getProperty("baseUrl"));
    protected static String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected static String password = System.getProperty("password", PropertyReader.getProperty("password"));
    //protected static String wrongPassword = System.getProperty("wrongPassword", PropertyReader.getProperty("wrongPassword"));

    @Parameters({"browser"})
    @BeforeMethod
    @Description("Открытие браузера")
    public void setup(@Optional("firefox") String browser) {
        if(browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
            Configuration.browserSize = "1920x1080";
            Configuration.headless = true;
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl =baseUrl;
            Configuration.reportsFolder = "target/allure-results";
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            Configuration.browserCapabilities = options;
            Configuration.browser = "chrome";
            Configuration.timeout = 10000;
            Configuration.clickViaJs = true;
            Configuration.baseUrl =baseUrl;
            Configuration.reportsFolder = "target/allure-results";
        }

        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        tShirtsPage = new TShirtsPage();
        cartPage = new CartPage();
        createAccountPage = new CreateAccountPage();
        personalInfoPage = new PersonalInfoPage();

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