package core.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;




public class RecoveryByPhone extends BasePage {

    // Локатор для кнопки выбора страны
    private SelenideElement countryDropdown = $("[name='country-select']");

    // Локатор для поля ввода номера телефона
    private SelenideElement phoneInputField = $("[name='phone-input']");

    // Локатор для кнопки Получить код
    private SelenideElement phoneSubmitButton = $("[name='phone-submit-btn']");



    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления через телефон")
    private void verifyPageElements() {
        countryDropdown.shouldBe(visible);
        phoneInputField.shouldBe(visible);
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.click(); // открываем список стран
        SelenideElement countryOption = $(String.format("option[data-test-id='%s']", countryName));
        countryOption.scrollTo();
        String countryCode = countryOption.getAttribute("value"); // берём код из value
        countryOption.click();
        return countryCode;
    }

}
