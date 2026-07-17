package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPage extends BasePage {
    private SelenideElement recoveryByPhoneButton = $("[name='recovery-phone-btn']");
    private SelenideElement recoveryByEmailButton = $("[name='recovery-email-btn']");
    private SelenideElement goToSupportButton = $("[name='support-contact-btn']");
    private SelenideElement getCode = $("[name='phone-submit-btn']");
    private SelenideElement errortext = $("[name='phone-error']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Получаем текст сообщения 'Введите номер телефона'")
    public String getMessageTextIncorrectPhoneNumber() {
        return errortext.shouldBe(visible).getText();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку 'Получить код'")
    public void clickButtonGetCode() {
        getCode.shouldBe(visible).click();
    }
}



