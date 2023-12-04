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
@Epic("Магазины")
@Story("Cоздание и редактирование магазина в админке")
@Feature("Shop")
public class ShopTests extends TestBase{
    @Test
    @DisplayName("Создание магазина в админке")
    @Owner("A.Babushkin")
    void createShopTest() {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        shopPage.openMallPage();
        shopPage.clickCreateShopButton();
        shopPage.inputShopName();
        shopPage.inputShopDescription();
        shopPage.inputShopShortDescription();
        shopPage.inputShopPhoneNumber();
        shopPage.inputShopEmail();
        shopPage.inputShopAddress();
        shopPage.clickSaveButton();
        shopPage.checkShop();
    }
    @Test
    @DisplayName("Редактирование магазина в админке")
    @Owner("A.Babushkin")
    void updateShopTest() {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        catalogPage.openMallPage();
        shopPage.openShop();
        shopPage.updateShopDescription(fakeShopName);
        shopPage.clickSaveButton2();
        shopPage.checkSaveChanges(fakeShopName);
    }
}
