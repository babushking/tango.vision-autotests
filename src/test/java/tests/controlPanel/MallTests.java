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
@Epic("Моллы")
@Story("Cоздание и редактирование молла в админке")
@Feature("Mall")
public class MallTests extends TestBase{
    @Test
    @DisplayName("Создание здания в админке")
    @Owner("A.Babushkin")
    void createMallTest() {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        mallPage.clickCreateMallButton();
        mallPage.clickSelectLogoButton();
        mallPage.inputName();
        mallPage.selectCountry();
        mallPage.clickCreateButton();
        mallPage.checkMall();
    }
    @Test
    @DisplayName("Клонирование здания в админке")
    @Owner("A.Babushkin")
    void createCloneMallTest() {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        mallPage.clickMenuButton();
        mallPage.selectCloneButton();
        mallPage.inputNameClone(mallfakeName);
        mallPage.clickCloneButton();
        mallPage.checkCloneMall(mallfakeName);
    }
}
