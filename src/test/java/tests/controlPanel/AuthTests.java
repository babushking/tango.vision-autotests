package tests.controlPanel;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("ui")
@Tag("controlPanel")
@Epic("Авторизация")
@Story("Авторизация пользователя в админке")
@Feature("Login")
public class AuthTests extends TestBase{
    @Test
    @DisplayName("Успешная авторизация")
    @Owner("A.Babushkin")
    void successfulAuthTest() {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        authorisationPage.checkUserName();
    }
}
