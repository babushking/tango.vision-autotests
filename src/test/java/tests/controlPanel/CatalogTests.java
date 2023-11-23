package tests.controlPanel;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("ui")
@Epic("Каталог")
@Story("Создание и редактирование каталога (категорий) в админке")
@Feature("Catalog")
public class CatalogTests extends TestBase{
    String fakeName = String.valueOf(faker.company().name());
    String fakeOrder = String.valueOf(faker.number().numberBetween(1, 100));

    @Test
    @DisplayName("Создание каталога")
    @Owner("A.Babushkin")
    void createCatalogTest() {
        //Авторизоваться в админке
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        //Провалиться в здание с названием Автотестовый
        step("Проваливаемся в здание Автотестовый", () ->{
            $(byText("Автотестовый")).scrollTo().click();
            sleep(2000);
        });
        // Перейти в раздел Каталог
        step("Переходим в раздел Каталог ", () -> $x("//fuse-nav-vertical-item[2]/a/span").click());
        // Нажать на кнопку "Создать каталог"
        step("Нажимаем на кнопку \"Создать каталог\"", () -> $x("//mat-icon[contains(.,'add')]").click());

        //Вводим название каталога в поле Name
        step("Вводим название каталога в поле Name", () -> {
            $("input[formcontrolname=name]").setValue(fakeName);
        });
        // Нажать кнопку Сохранить
        step("Нажимаем кнопку  Сохранить", () -> $x("//span[contains(.,'Save')]").click());
        // Проверить, что создался каталог с названием fakeName
        step("Проверяем, что на странице появился mall с названием Copy", () -> {
            $(new ByText(fakeName)).shouldBe(visible);
        });
    }
    @Test
    @DisplayName("Редактирование каталога")
    @Owner("A.Babushkin")
    void updateCatalogTest() {
        //Авторизоваться в админке
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        sleep(2000);
        //Провалиться в здание с названием Автотестовый
        step("Проваливаемся в здание Автотестовый", () ->{
            $(byText("Автотестовый")).scrollTo().click();
            sleep(2000);
        });
        // Перейти в раздел Каталог
        step("Переходим в раздел Каталог ", () -> $x("//fuse-nav-vertical-item[2]/a/span").click());
        // Проваливаемся в каталог "Автотестовый каталог"
        step("Проваливаемся в каталог \"Автотестовый каталог\"", () -> $(byText("Автотестовый каталог")).scrollTo().click());

        //Вводим число в поле Order
        step("Вводим число в поле Order", () -> {
            $("input[type=number]").setValue(fakeOrder);
        });
        // Нажать кнопку Сохранить
        step("Нажимаем кнопку  Сохранить", () -> $x("//mat-dialog-actions/button[2]/span").click());
        // Проверить, что изменения сохранены
        step("Проваливаемся в каталог \"Автотестовый каталог\"", () -> {
            $(byText("Автотестовый каталог")).scrollTo().click();
            String text = $("input[type=number]").getValue();
            assertEquals(fakeOrder, text);
        });
    }
}
