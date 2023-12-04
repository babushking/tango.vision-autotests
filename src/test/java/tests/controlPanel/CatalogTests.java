package tests.controlPanel;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ui")
@Epic("Каталог")
@Story("Создание и редактирование каталога (категорий) в админке")
@Feature("Catalog")
public class CatalogTests extends TestBase{
    @Test
    @DisplayName("Создание каталога")
    @Owner("A.Babushkin")
    void createCatalogTest() {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        catalogPage.openMallPage();
        catalogPage.openCatalogPage();
        catalogPage.clickCreateCatalogButton();
        catalogPage.inputName(fakeName);
        catalogPage.clickSaveButton();
        catalogPage.checkCatalog(fakeName);
    }
    @Test
    @DisplayName("Редактирование каталога")
    @Owner("A.Babushkin")
    void updateCatalogTest() {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        catalogPage.openMallPage();
        catalogPage.openCatalogPage();
        catalogPage.openCatalog();
        catalogPage.inputOrder(fakeOrder);
        catalogPage.clickSaveButton2();
        catalogPage.checkSaveChanges(fakeOrder);
    }
}
