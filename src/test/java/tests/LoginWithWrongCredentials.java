package tests;

import core.pages.LoginPage;
import core.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredentials extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        //Принятие cookies и политики
        loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.acceptPrivacyButton();
    }


    @Test
    public void loginWithWrongCredentials() {
        //Проверка входа с некорректными данными
        loginPage.login("incorrectUser", "incorrectPassword");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginWithEmptyLogin() {
        // Попытка входа с пустым логином и произвольным паролем
        loginPage.login("", "somePassword");

        // Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке для пустого логина не отображается");

        // Проверка текста сообщения (подставьте реальный текст с вашей страницы)
        String expectedErrorMessage = "Введите телефон, email или логин и пароль."; // или "Поле логина обязательно"
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginWithEmptyPassword() {
        // Попытка входа с пустым паролем и произвольным логином
        loginPage.login("someUser", "");

        // Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке для пустого логина не отображается");

        // Проверка текста сообщения (подставьте реальный текст с вашей страницы)
        String expectedErrorMessage = "Введите телефон, email или логин и пароль."; // или "Поле логина обязательно"
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }


}
