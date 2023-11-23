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

import java.util.Map;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    Dotenv dotenv = Dotenv.load();
    // Получение значения переменной окружения API_KEY
    String login = dotenv.get("LOGIN");
    // Получение значения переменной окружения DB_PASSWORD
    String password = dotenv.get("PASSWORD-DEV");
    Faker faker = new Faker();
    AuthorisationPage authorisationPage = new AuthorisationPage();

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://control.tangovision.dev/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "2100x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


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

