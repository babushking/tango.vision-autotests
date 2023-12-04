package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopPage {
    public void openMallPage() {
        step("Проваливаемся в здание", () -> $(".mat-row-link").click());
    }
    public void clickCreateShopButton() {
        step("Нажимаем на кнопку 'Создать shop' ", () -> $(".bottom-right .mat-icon").shouldBe(Condition.visible).click());
    }
    public void inputShopName() {
        step("Вводим название shop в поле Name", () -> {
            $("#mat-input-15").scrollTo().setValue("Auto Shop Delete Me");
        });
    }
    public void inputShopDescription() {
        step("Вводим описание в поле Описание", () -> {
            $("#mat-input-16").scrollTo().setValue("тут должно быть описание");
        });
    }
    public void inputShopShortDescription() {
        step("Вводим короткое описание в поле Короткое описание", () -> {
            $("#mat-input-17").scrollTo().setValue("тут должно быть короткое описание");
        });
    }
    public void inputShopPhoneNumber() {
        step("Вводим номер телефона в поле Номер телефона", () -> {
            $("#mat-input-7").scrollTo().setValue("+111100002222");
        });
    }
    public void inputShopEmail() {
    step("Вводим email в поле email", () -> {
        $("#mat-input-8").scrollTo().setValue("hhsdshggh@jh.kk");
    });
    }
    public void inputShopAddress() {
        step("Вводим адрес в поле Адрес", () -> {
            $("#mat-input-11").scrollTo().setValue("тут должен быть адрес");
        });
    }
    public void clickSaveButton() {
        step("Нажимаем кнопку Сохранить", () -> $(".mat-raised-button > .mat-button-wrapper").click());
    }
    public void checkShop() {
        step("Проверяем, что на странице появился shop с названием Auto Shop Delete Me", () -> {
            $("body").shouldHave(text("Auto Shop Delete Me"));
        });
    }
    public void openShop() {
        step("Проваливаемся в магазин Автотестовый магазин", () -> $(byText("Автотестовый магазин")).scrollTo().click());
    }
    public void updateShopDescription(String fakeShopName) {
        step("Добавляем описание в поле Описание", () ->{
            $("textarea[formcontrolname=description]").setValue(fakeShopName);
        });
    }
    public void clickSaveButton2() {
        step("Нажимае кнопку сохранить", () -> $(".mat-raised-button").click());
    }
    public void checkSaveChanges(String fakeShopName) {
        step("Проваливаемся в магазин Автотестовый магазин", () ->{
            $(byText("Автотестовый магазин")).scrollTo().click();
            String text = $("textarea[formcontrolname=description]").shouldBe(Condition.visible).getValue();
            assertEquals(fakeShopName, text);
        });
    }
}
