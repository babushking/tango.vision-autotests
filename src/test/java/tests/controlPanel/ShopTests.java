package tests.controlPanel;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        //Авторизоваться в админке
        step("Авторизуемся в админке", () -> {
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        });
        //Провалиться в здание
        step("Проваливаемся в здание", () -> $(".mat-row-link").click());
        sleep(2000);
        //Нажать на кнопку "Создать shop"
        step("Нажимаем на кнопку 'Создать shop' ", () -> $(".bottom-right .mat-icon").click());
        //Ввести название shop в поле Name
        step("Вводим название shop в поле Name", () -> {
            $("#mat-input-15").scrollTo().setValue("Auto Shop Delete Me");
        });
        //Ввести описание в поле Описание
        step("Вводим описание в поле Описание", () -> {
            $("#mat-input-16").scrollTo().setValue("тут должно быть описание");
        });
        //Ввести короткое описание в поле Короткое описание
        step("Вводим короткое описание в поле Короткое описание", () -> {
            $("#mat-input-17").scrollTo().setValue("тут должно быть короткое описание");
        });
        //Ввести номер телефона в поле Номер телефона
        step("Вводим номер телефона в поле Номер телефона", () -> {
            $("#mat-input-7").scrollTo().setValue("+111100002222");
        });
        //Ввести email в поле email
        step("Вводим email в поле email", () -> {
            $("#mat-input-8").scrollTo().setValue("hhsdshggh@jh.kk");
        });
        //Ввести адрес в поле Адрес
        step("Вводим адрес в поле Адрес", () -> {
            $("#mat-input-11").scrollTo().setValue("тут должен быть адрес");
        });
        //Нажать на кнопку "Сохранить"
        step("Нажимаем кнопку Сохранить", () -> $(".mat-raised-button > .mat-button-wrapper").click());
        //Проверить, что на странице появился shop с названием Auto Shop Delete Me
        step("Проверяем, что на странице появился shop с названием Auto Shop Delete Me", () -> {
            $("body").shouldHave(text("Auto Shop Delete Me"));
        });
    }
    @Test
    @DisplayName("Редактирование магазина в админке")
    @Owner("A.Babushkin")
    void updateShopTest() {
        String fakeName = String.valueOf(faker.name().title());
        //Авторизоваться в админке
        step("Авторизуемся в админке", () -> {
            authorisationPage.openPage();
            authorisationPage.inputLogin(login);
            authorisationPage.inputPassword(password);
            authorisationPage.clickSubmit();
        });
        //Провалиться в здание с названием Автотестовый
        step("Проваливаемся в здание Автотестовый", () ->{
            $(byText("Автотестовый")).scrollTo().click();
            sleep(2000);
        });
        // Провалиться в магазин с названием Автотестовый магазин
        step("Проваливаемся в магазин Автотестовый магазин", () -> $(byText("Автотестовый магазин")).scrollTo().click());
        //Добавить описание в поле Описание
        step("Добавляем описание в поле Описание", () ->{
            $("textarea[formcontrolname=description]").setValue(fakeName);
        });
        // Нажимае кнопку сохранить
        step("Нажимае кнопку сохранить", () -> $(".mat-raised-button").click());
        // Проверить что изменения сохранены
        step("Проваливаемся в магазин Автотестовый магазин", () ->{
            $(byText("Автотестовый магазин")).scrollTo().click();
            String text = $("textarea[formcontrolname=description]").getValue();
            assertEquals(fakeName, text);
        });
    }
}
