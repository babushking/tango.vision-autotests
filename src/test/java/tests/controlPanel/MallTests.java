package tests.controlPanel;

import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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
        //Авторизоваться в админке
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        //Нажать на кнопку "Создать mall"
        step("Нажимаем кнопку создать mall", () -> $(".bottom-right .mat-icon").click());

        //Нажать на кнопку "Выбрать лого"
        step("Нажимаем на кнопку 'Выбрать лого'", () -> {
            $(".files > input").uploadFile(new File("src/test/resources/logo Tango.vision.png"));
        });
        //Ввести название молла в поле Name
        step("Вводим название молла в поле Name", () -> {
            $("#mat-input-2").scrollTo().setValue("AutoTestDeleteMe");
        });
        //Выбрать страну
        step("Выбираем страну", () -> {
            $(".mat-select").click();
            $("#mat-option-1 > .mat-option-text").click();
        });
        //Нажать на кнопку "Создать"
        step("Нажимаем кнопку создать", () -> $(".mat-raised-button > .mat-button-wrapper").click());
        //Проверить, что на странице появился mall с названием AutoTestDeleteMe
        step("Проверяем, что на странице появился mall с названием AutoTestDeleteMe", () -> {
            $("body").shouldHave(text("AutoTestDeleteMe"));
        });
    }
    @Test
    @DisplayName("Редактирование здания в админке")
    @Owner("A.Babushkin")
    void createCloneMallTest() {
        String fakeName = String.valueOf(faker.name().title());
        //Авторизоваться в админке
        authorisationPage.openPage();
        authorisationPage.inputLogin(login);
        authorisationPage.inputPassword(password);
        authorisationPage.clickSubmit();
        // Нажать меню в строке здания
        step("Нажимаем на кнопку меню в строке здания", () -> $x("//div[@id='container-3']/content/app-malls/div/mat-table/mat-row/mat-cell[4]/button/span/mat-icon").click());
        // Выбрать пункт Клонировать
        step("Выбираем пункт Клонировать", () -> $(".cdk-focused").click());
        //Вводим название для склонированного здания
        step("Вводим название для склонированного здания", () -> {
            $("input[formcontrolname=name]").setValue(fakeName);
        });
        // Нажать кнопку Клонировать
        step("Нажимаем кнопку  Клонировать", () -> $(".mat-raised-button > .mat-button-wrapper").click());
        // Проверить, что создалось здание с названием Copy
        step("Проверяем, что на странице появился mall с названием Copy", () -> {
            $(new ByText(fakeName)).shouldBe(visible);
        });
    }
}
