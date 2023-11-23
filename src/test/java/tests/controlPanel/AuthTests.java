package tests.controlPanel;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthorisationPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
@Tag("ui")
@Tag("controlPanel")
@Epic("Авторизация")
@Story("Авторизация пользователя в админке")
@Feature("Login")
public class AuthTests extends TestBase{
    AuthorisationPage authorisationPage = new AuthorisationPage();
    @Test
    @DisplayName("Успешная авторизация")
    @Owner("A.Babushkin")
    void successfulAuthTest() {
        //Авторизоваться в админке
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        step("Проверяем имя(email) авторизованного пользователя", () -> {
            $(".username").shouldHave(text("Юай Автотестович"));
        });
    }


}
