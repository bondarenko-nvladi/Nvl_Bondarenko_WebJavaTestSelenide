package core.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement usernameField = $("[name='login-phone-email']");
    private SelenideElement passwordField = $("[name='login-password']");
    private SelenideElement loginButton = $("[name='login-submit-btn']");
    private SelenideElement forgotPasswordLink = $("[name='forgot-password-link']");
    private SelenideElement registrationButton = $("[name='hero-register-btn']");

    private SelenideElement phoneTitle = $("[name='phone-title']");
    private SelenideElement emailTitle = $("[name='email-title']");


    //Локаторы для кнопок соцсетей
//    private SelenideElement vkButton = $("[data-l='t,vkc']");
//    private SelenideElement googleButton = $("[data-l='t,google']");
//    private SelenideElement mailRuButton = $("[data-l='t,mailru']");

    //Локатор для элемента с сообщением об ошибка входа
    private SelenideElement errorMessage = $("[name='login-error']");

    //локатор для перехода к восстановлению
    private SelenideElement goToRecoveryButton = $("[name='lockout-recover-btn']");

    {
        verifyPageElements();
    }


    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        //vkButton.shouldBe(visible);
        //googleButton.shouldBe(visible);
        //mailRuButton.shouldBe(visible);
    }

    @Step("Проверем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Проверем видимость титульного названия 'Указать телефон' на странице поиска по телефону")
    public boolean isMessageVisiblePhonePage() {
        phoneTitle.shouldBe(visible);
        return phoneTitle.shouldBe(visible).exists();
    }

    @Step("Проверем видимость титульного названия 'Почта' на странице поиска по почте")
    public boolean isMessageVisibleEmailPage() {
        emailTitle.shouldBe(visible);
        return emailTitle.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином {username} and {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step ("Входим на сайт с логином {username} and {password}")
    public void setPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем Восстановить профиль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }



//    // Методы для перехода на страницы авторизации через соцсети
//    @Step("Входим на сайт через Вконтакте")
//    public void loginWithVK() {
//        vkButton.shouldBe(visible).click();
//    }
//
//    @Step("Входим через google")
//    public void loginWithGoogle() {
//        googleButton.shouldBe(visible).click();
//    }
//
//    @Step("Входим через mail.ru")
//    public void loginWithMailru() {
//        mailRuButton.shouldBe(visible).click();
//    }

    public void acceptCookie() {
    }

    public void acceptPrivacyButton() {
    }
}





