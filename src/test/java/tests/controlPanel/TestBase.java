package tests.controlPanel;

import com.github.javafaker.Faker;
import helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.AuthorisationPage;
import pages.CatalogPage;
import pages.MallPage;
import pages.ShopPage;
import java.util.Map;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    ShopPage shopPage = new ShopPage();
    CatalogPage catalogPage = new CatalogPage();
    MallPage mallPage = new MallPage();
    AuthorisationPage authorisationPage = new AuthorisationPage();
    Faker faker = new Faker();
    Dotenv dotenv = Dotenv.load();
    String login = dotenv.get("LOGIN");
    String password = dotenv.get("PASSWORD-DEV");
    String fakeName = String.valueOf(faker.company().name());
    String fakeOrder = String.valueOf(faker.number().numberBetween(1, 100));
    String mallfakeName = String.valueOf(faker.name().title());
    String fakeShopName = String.valueOf(faker.name().title());

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://control.tangovision.dev/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "2100x1080";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}