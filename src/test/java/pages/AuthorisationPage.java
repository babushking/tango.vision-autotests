package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AuthorisationPage {
    public void openPage() {
        step("Открываем страницу авторизации", () -> open("auth/sign-in"));
    }
    public void inputLogin(String login) {
        step("Вводим логин", () -> {
            $("[type=email]").setValue(login);
        });
    }
    public void inputPassword(String password) {
        step("Вводим пароль", () -> {
            $("[type=password]").setValue(password);
        });
    }
    public void clickSubmit() {
        step("Нажимаем кнопку войти", () -> $("[type=submit]").click());
    }
    public void checkUserName() {
        step("Проверяем имя(email) авторизованного пользователя", () -> {
            $(".username").shouldHave(text("Юай Автотестович"));
        });
    }
}
