package pages;

import com.codeborne.selenide.selector.ByText;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class MallPage {
    public void clickCreateMallButton() {
        step("Нажимаем кнопку создать mall", () -> $(".bottom-right .mat-icon").click());
    }
    public void clickSelectLogoButton() {
        step("Нажимаем на кнопку 'Выбрать лого'", () -> {
            $(".files > input").uploadFile(new File("src/test/resources/logo Tango.vision.png"));
        });
    }
    public void inputName() {
        step("Вводим название молла в поле Name", () -> {
            $("#mat-input-2").scrollTo().setValue("AutoTestDeleteMe");
        });
    }
    public void selectCountry() {
        step("Выбираем страну", () -> {
            $(".mat-select").click();
            $("#mat-option-1 > .mat-option-text").click();
        });
    }
    public void clickCreateButton() {
        step("Нажимаем кнопку Создать", () -> $(".mat-raised-button > .mat-button-wrapper").click());
    }
    public void checkMall() {
        step("Проверяем, что на странице появился mall с названием AutoTestDeleteMe", () -> {
            $("body").shouldHave(text("AutoTestDeleteMe"));
        });
    }
    public void clickMenuButton() {
        step("Нажимаем на кнопку меню в строке здания", () -> $x("//div[@id='container-3']/content/app-malls/div/mat-table/mat-row/mat-cell[4]/button/span/mat-icon").click());
    }
    public void selectCloneButton() {
        step("Выбираем пункт Клонировать", () -> $(".cdk-focused").click());
    }
    public void inputNameClone(String mallfakeName) {
        step("Вводим название для склонированного здания", () -> {
            $("input[formcontrolname=name]").setValue(mallfakeName);
        });
    }
    public void clickCloneButton() {
        step("Нажимаем кнопку  Клонировать", () -> $(".mat-raised-button > .mat-button-wrapper").click());
    }
    public void checkCloneMall(String mallfakeName) {
        step("Проверяем, что на странице появился mall с названием Copy", () -> {
            $(new ByText(mallfakeName)).shouldBe(visible);
        });
    }
}
