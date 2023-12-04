package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogPage {
    public void openMallPage() {
        step("Проваливаемся в здание Автотестовый", () -> $(byText("Автотестовый")).scrollTo().click());
    }
    public void openCatalogPage() {
        step("Переходим в раздел Каталог ", () -> $x("//fuse-nav-vertical-item[2]/a/span").shouldBe(Condition.visible).click());
    }
    public void clickCreateCatalogButton() {
        step("Нажимаем на кнопку \"Создать каталог\"", () -> $x("//mat-icon[contains(.,'add')]").click());
    }
    public void inputName(String fakeName) {
        step("Вводим название каталога в поле Name", () -> {
            $("input[formcontrolname=name]").setValue(fakeName);
        });
    }
    public void clickSaveButton() {
        step("Нажимаем кнопку  Сохранить", () -> $x("//span[contains(.,'Save')]").click());
    }
    public void checkCatalog(String fakeName) {
        step("Проверяем, что на странице появился каталог с названием Copy", () -> {
            $(new ByText(fakeName)).shouldBe(visible);
        });
    }
    public void openCatalog() {
        step("Проваливаемся в каталог \"Автотестовый каталог\"", () -> $(byText("Автотестовый каталог")).scrollTo().click());
    }
    public void inputOrder(String fakeOrder) {
        step("Вводим число в поле Order", () -> {
            $("input[type=number]").setValue(fakeOrder);
        });
    }
    public void clickSaveButton2() {
        step("Нажимаем кнопку  Сохранить", () -> $x("//mat-dialog-actions/button[2]/span").click());
    }
    public void checkSaveChanges(String fakeOrder) {
        step("Проваливаемся в каталог \"Автотестовый каталог\"", () -> {
            $(byText("Автотестовый каталог")).scrollTo().click();
            String text = $("input[type=number]").getValue();
            assertEquals(fakeOrder, text);
        });
    }
}
