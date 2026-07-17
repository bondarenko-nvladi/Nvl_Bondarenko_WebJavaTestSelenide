package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryByPhone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl); //принятие кукис и политики
        loginPage = new LoginPage();
        //loginPage.acceptCookie();
        //loginPage.accept.PrivacyButton();
    }

    @Test
    public void anonymRecoveryTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        RecoveryByPhone recoveryByPhone = new RecoveryByPhone();
        String countryCode = recoveryByPhone.selectCountryByName("country-peru");
        assertEquals("+51", countryCode, "Код страны не совпадает с ожидаемым");
    }

    @Test
    public void anonymRecoveryByPhoneTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();
        RecoveryByPhone recoveryByPhone = new RecoveryByPhone();
        // Выбираем страну из списка, в скобках прописываем название страны которую ищем: country-peru, country-russia
        String countryCode = recoveryByPhone.selectCountryByName("country-peru");
        // Нажимаем на кнопу 'Получить код'
        anonymRecoveryPage.clickButtonGetCode();
        // Названит строки которую мы хотим найти
        String expectedErrorMessage = "Введите номер телефона.";
        // Название элемента котороый мы получаем из кода страницы
        String actualErrorMessage = anonymRecoveryPage.getMessageTextIncorrectPhoneNumber();
        // Сверяем найденый текст в тем что мы указали на 58 строке
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void anonymRecoveryByEmailTest() {
        loginPage.login("incorrectUser", "incorrectPassword");
        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();
        assertTrue(loginPage.isMessageVisibleEmailPage());
    }



}

